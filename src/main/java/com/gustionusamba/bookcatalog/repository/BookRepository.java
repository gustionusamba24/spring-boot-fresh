package com.gustionusamba.bookcatalog.repository;

import com.gustionusamba.bookcatalog.domain.Book;

import java.util.List;

public interface BookRepository {

    public Book findBookById(Long id);

    public List<Book> findAll();
}
