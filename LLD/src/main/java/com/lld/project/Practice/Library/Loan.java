package com.lld.project.Practice.Library;

// Loan

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Loan {
    private static final BigDecimal DAILY_FINE_RATE = new BigDecimal("5.00");
    private static final int        LOAN_PERIOD_DAYS = 14;

    private final String     loanId;
    private final BookItem   bookItem;
    private final Member     member;
    private final LocalDate  borrowDate;
    private final LocalDate  dueDate;
    private LocalDate        returnDate;

    public Loan(BookItem bookItem, Member member) {
        this.loanId     = UUID.randomUUID().toString();
        this.bookItem   = bookItem;
        this.member     = member;
        this.borrowDate = LocalDate.now();
        this.dueDate    = borrowDate.plusDays(LOAN_PERIOD_DAYS);
    }

    // "Template Method hook: subclasses could override getDailyRate()
    //  for premium members. The skeleton stays here."
    protected BigDecimal getDailyRate() { return DAILY_FINE_RATE; }

    public BigDecimal calculateFine() {
        LocalDate end = (returnDate != null) ? returnDate : LocalDate.now();
        long overdueDays = ChronoUnit.DAYS.between(dueDate, end);
        if (overdueDays <= 0) return BigDecimal.ZERO;
        return getDailyRate().multiply(BigDecimal.valueOf(overdueDays));
    }

    public void recordReturn()          { this.returnDate = LocalDate.now(); }
    public boolean isOverdue()          { return LocalDate.now().isAfter(dueDate); }

    public String   getLoanId()         { return loanId; }
    public BookItem getBookItem()       { return bookItem; }
    public Member   getMember()         { return member; }
    public LocalDate getDueDate()       { return dueDate; }
}
