package com.lld.project.Practice.Library;

import com.lld.project.Practice.Library.Searching.SearchStrategy;

import java.util.*;

public class Catalog {
    private final Map<String, Book>          books     = new HashMap<>();
    private final Map<String, List<BookItem>> bookItems = new HashMap<>();
    private SearchStrategy searchStrategy;

    public Catalog(SearchStrategy strategy) {
        this.searchStrategy = strategy;
    }

    public void setSearchStrategy(SearchStrategy s) { this.searchStrategy = s; }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        bookItems.putIfAbsent(book.getIsbn(), new ArrayList<>());
    }

    public void addBookItem(BookItem item) {
        String isbn = item.getBook().getIsbn();
        bookItems.computeIfAbsent(isbn, k -> new ArrayList<>()).add(item);
    }

    public List<Book> search(String query) {
        return searchStrategy.search(books, query);
    }

    public Optional<BookItem> getAvailableItem(String isbn) {
        return bookItems.getOrDefault(isbn, List.of())
                .stream()
                .filter(BookItem::isAvailable)
                .findFirst();
    }

    public Book getBook(String isbn) { return books.get(isbn); }
}
