package com.gustionusamba.bookcatalog.repository.impl;

import com.gustionusamba.bookcatalog.domain.Book;
import com.gustionusamba.bookcatalog.repository.BookRepository;
import lombok.Data;

import java.util.Map;

@Data
public class BookRepositoryImpl implements BookRepository {

    private Map<Long, Book> bookMap;

    @Override
    public Book findBookById(Long id) {
        Book book = bookMap.get(id);
        return book;
    }
}
