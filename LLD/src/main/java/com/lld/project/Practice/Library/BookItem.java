package com.lld.project.Practice.Library;

import java.time.LocalDate;

public class BookItem {
    private final String   barcode;
    private final Book     book;
    private BookStatus     status = BookStatus.AVAILABLE;
    private LocalDate      dueDate;

    public BookItem(String barcode, Book book) {
        this.barcode = barcode;
        this.book    = book;
    }

    public boolean isAvailable()  { return status == BookStatus.AVAILABLE; }
    public BookStatus getStatus() { return status; }
    public String getBarcode()    { return barcode; }
    public Book getBook()         { return book; }
    public LocalDate getDueDate() { return dueDate; }

    public void checkout(LocalDate due) {
        if (status != BookStatus.AVAILABLE)
            throw new IllegalStateException("BookItem not available: " + barcode);
        this.status  = BookStatus.BORROWED;
        this.dueDate = due;
    }

    public void return_() {
        this.status  = BookStatus.AVAILABLE;
        this.dueDate = null;
    }

    public void reserve() {
        if (status != BookStatus.AVAILABLE)
            throw new IllegalStateException("Cannot reserve non-available item");
        this.status = BookStatus.RESERVED;
    }

    public void markLost() { this.status = BookStatus.LOST; }
}
