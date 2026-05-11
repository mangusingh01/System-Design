package com.lld.project.Practice.Library.Searching;


import com.lld.project.Practice.Library.Book;

import java.util.List;
import java.util.Map;

public interface SearchStrategy {
    List<Book> search(Map<String, Book> catalog, String query);
}
