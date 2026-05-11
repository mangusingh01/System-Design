package com.lld.project.Practice.Library.Searching;

import com.lld.project.Practice.Library.Book;

import java.util.List;
import java.util.Map;

public class IsbnSearchStrategy implements SearchStrategy {
    @Override
    public List<Book> search(Map<String, Book> catalog, String query) {
        Book b = catalog.get(query);
        return b != null ? List.of(b) : List.of();
    }
}
