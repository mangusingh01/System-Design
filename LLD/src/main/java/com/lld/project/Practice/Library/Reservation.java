package com.lld.project.Practice.Library;

// Reservation

import java.time.LocalDate;
import java.util.UUID;

public class Reservation {
    private final String    reservationId;
    private final Member    member;
    private final String    isbn;
    private final LocalDate reservedOn;

    public Reservation(Member member, String isbn) {
        this.reservationId = UUID.randomUUID().toString();
        this.member        = member;
        this.isbn          = isbn;
        this.reservedOn    = LocalDate.now();
    }

    public String  getReservationId() { return reservationId; }
    public Member  getMember()        { return member; }
    public String  getIsbn()          { return isbn; }
    public LocalDate getReservedOn()  { return reservedOn; }
}
