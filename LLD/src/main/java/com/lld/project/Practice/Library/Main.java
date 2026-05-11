package com.lld.project.Practice.Library;

import com.lld.project.Practice.Library.Notify.EmailNotifier;
import com.lld.project.Practice.Library.Searching.AuthorSearchStrategy;
import com.lld.project.Practice.Library.Searching.TitleSearchStrategy;

public class Main {
    public static void main(String[] args) {

        // Wire up infrastructure
        Catalog catalog = new Catalog(new TitleSearchStrategy());
        Library library = Library.getInstance(catalog);
        library.addListener(new EmailNotifier());

        Librarian librarian = new Librarian("L001", library, catalog);

        // Add book + two copies
        Book effectiveJava = new Book(
                "978-0134685991", "Effective Java", "Joshua Bloch", "Programming");
        librarian.addBook(effectiveJava);
        librarian.addBookItem(new BookItem("EJ-COPY-001", effectiveJava));
        librarian.addBookItem(new BookItem("EJ-COPY-002", effectiveJava));

        // Register members
        Member alice = new Member("M001", "Alice");
        Member bob   = new Member("M002", "Bob");
        librarian.registerMember(alice);
        librarian.registerMember(bob);

        // Alice borrows one copy
        Loan loan1 = library.borrowBook("M001", "978-0134685991");

        // Bob borrows the second copy
        Loan loan2 = library.borrowBook("M002", "978-0134685991");

        // Alice tries to borrow again — no copies left, she reserves
        library.reserveBook("M001", "978-0134685991");

        // Bob returns — triggers notification to Alice
        library.returnBook(loan2.getLoanId());

        // Search by author
        library.setSearchStrategy(new AuthorSearchStrategy());
        library.search("Bloch").forEach(b ->
                System.out.println("Found: " + b.getTitle()));
    }
}
