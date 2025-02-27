package com.gustionusamba.bookcatalog.repository;

import com.gustionusamba.bookcatalog.domain.Book;

import java.util.List;

public interface BookRepository {

    Book findBookById(Long id);

    List<Book> findAll();

    void save(Book book);

    void update(Book book);

    void delete(Long id);
}
