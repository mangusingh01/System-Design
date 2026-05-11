package com.lld.project.Practice.Library;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private static final int MAX_BORROW_LIMIT = 5;

    private final String memberId;
    private final String name;
    private MemberStatus status = MemberStatus.ACTIVE;
    private final List<Loan>        activeLoans  = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name     = name;
    }

    // "canBorrow encapsulates two rules — status check and limit check —
    //  in one place. Library delegates to this; it doesn't re-implement
    //  the rules inline. High cohesion."
    public boolean canBorrow() {
        return status == MemberStatus.ACTIVE
                && activeLoans.size() < MAX_BORROW_LIMIT;
    }

    public void addLoan(Loan loan)              { activeLoans.add(loan); }
    public void removeLoan(Loan loan)           { activeLoans.remove(loan); }
    public void addReservation(Reservation r)  { reservations.add(r); }
    public void removeReservation(Reservation r){ reservations.remove(r); }

    public String        getMemberId()     { return memberId; }
    public String        getName()         { return name; }
    public MemberStatus  getStatus()       { return status; }
    public List<Loan>    getActiveLoans()  { return List.copyOf(activeLoans); }
    public void          suspend()         { this.status = MemberStatus.SUSPENDED; }
    public void          activate()        { this.status = MemberStatus.ACTIVE; }
}
