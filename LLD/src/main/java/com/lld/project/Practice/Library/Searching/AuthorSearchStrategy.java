package com.lld.project.Practice.Library.Searching;

import com.lld.project.Practice.Library.Book;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AuthorSearchStrategy implements SearchStrategy {
    @Override
    public List<Book> search(Map<String, Book> catalog, String query) {
        String q = query.toLowerCase();
        return catalog.values().stream()
                .filter(b -> b.getAuthor().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
