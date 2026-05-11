package com.lld.project.Practice.Library;

public class Librarian {
    private final String   employeeId;
    private final Library  library;
    private final Catalog  catalog;

    public Librarian(String employeeId, Library library, Catalog catalog) {
        this.employeeId = employeeId;
        this.library    = library;
        this.catalog    = catalog;
    }

    public void addBook(Book book) {
        catalog.addBook(book);
        System.out.println("Added book: " + book.getTitle());
    }

    public void addBookItem(BookItem item) {
        catalog.addBookItem(item);
        System.out.printf("Added copy [%s] of '%s'%n",
                item.getBarcode(), item.getBook().getTitle());
    }

    public void registerMember(Member member) {
        library.registerMember(member);
        System.out.println("Registered member: " + member.getName());
    }
}
