package com.lld.project.Practice.Library;

//  Library — Singleton + Facade 
// "Library is a Facade: it hides the complexity of coordinating
//  Catalog, Loan records, the reservation queue, and notification
//  dispatch behind a single clean API."

import com.lld.project.Practice.Library.Notify.NotificationListener;
import com.lld.project.Practice.Library.Searching.SearchStrategy;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Library {

    private static volatile Library instance;

    private final Catalog                          catalog;
    private final Map<String, Member>              members      = new ConcurrentHashMap<>();
    private final Map<String, Loan>                activeLoans  = new ConcurrentHashMap<>();
    // isbn -> FIFO queue of reservations
    private final Map<String, Queue<Reservation>>  reservations = new ConcurrentHashMap<>();
    private final List<NotificationListener>       listeners    = new ArrayList<>();

    private Library(Catalog catalog) {
        this.catalog = catalog;
    }

    public static Library getInstance(Catalog catalog) {
        if (instance == null) {
            synchronized (Library.class) {
                if (instance == null) instance = new Library(catalog);
            }
        }
        return instance;
    }

    //  Admin 
    public void registerMember(Member m)     { members.put(m.getMemberId(), m); }
    public void addListener(NotificationListener l) { listeners.add(l); }

    //  Borrow 
    public Loan borrowBook(String memberId, String isbn) {
        Member member = getMember(memberId);

        if (!member.canBorrow())
            throw new IllegalStateException(
                    "Member cannot borrow: status=" + member.getStatus()
                            + ", loans=" + member.getActiveLoans().size());

        BookItem item = catalog.getAvailableItem(isbn)
                .orElseThrow(() -> new IllegalStateException(
                        "No available copy for ISBN: " + isbn));

        item.checkout(item.getDueDate() == null
                ? java.time.LocalDate.now().plusDays(14)
                : item.getDueDate());

        Loan loan = new Loan(item, member);
        member.addLoan(loan);
        activeLoans.put(loan.getLoanId(), loan);

        System.out.printf("✓ %s borrowed '%s' | Due: %s | Loan: %s%n",
                member.getName(), item.getBook().getTitle(),
                loan.getDueDate(), loan.getLoanId());

        return loan;
    }

    //  Return 
    public BigDecimal returnBook(String loanId) {
        Loan loan = activeLoans.remove(loanId);
        if (loan == null)
            throw new IllegalArgumentException("Unknown loan: " + loanId);

        loan.recordReturn();
        BigDecimal fine = loan.calculateFine();

        loan.getBookItem().return_();
        loan.getMember().removeLoan(loan);

        System.out.printf("✓ '%s' returned | Fine: ₹%.2f%n",
                loan.getBookItem().getBook().getTitle(), fine);

        // Check reservation queue — notify first waiter
        String isbn = loan.getBookItem().getBook().getIsbn();
        notifyNextReservation(isbn);

        return fine;
    }

    //  Reserve 
    // "Called when no copy is currently available.
    //  Uses a FIFO Queue to honour reservation order."
    public Reservation reserveBook(String memberId, String isbn) {
        Member member = getMember(memberId);

        if (catalog.getBook(isbn) == null)
            throw new IllegalArgumentException("Book not found: " + isbn);

        Reservation reservation = new Reservation(member, isbn);
        reservations
                .computeIfAbsent(isbn, k -> new LinkedList<>())
                .add(reservation);
        member.addReservation(reservation);

        System.out.printf("✓ %s reserved '%s' (position %d in queue)%n",
                member.getName(), isbn,
                reservations.get(isbn).size());

        return reservation;
    }

    //  Search (delegates to Strategy) 
    public List<Book> search(String query) {
        return catalog.search(query);
    }

    public void setSearchStrategy(SearchStrategy s) {
        catalog.setSearchStrategy(s);
    }

    //  Internal 
    private Member getMember(String id) {
        Member m = members.get(id);
        if (m == null) throw new IllegalArgumentException("Unknown member: " + id);
        return m;
    }

    private void notifyNextReservation(String isbn) {
        Queue<Reservation> q = reservations.get(isbn);
        if (q == null || q.isEmpty()) return;

        Reservation next = q.poll();
        next.getMember().removeReservation(next);

        // "Observer pattern: Library doesn't know about email/SMS.
        //  It just fires the event. New notification channels add
        //  a listener — Library never changes."
        listeners.forEach(l ->
                l.onBookAvailable(isbn, next.getMember().getMemberId()));
    }
}
