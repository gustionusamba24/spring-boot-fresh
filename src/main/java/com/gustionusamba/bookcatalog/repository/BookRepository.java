package com.gustionusamba.bookcatalog.repository;

import com.gustionusamba.bookcatalog.domain.Book;

public interface BookRepository {

    public Book findBookById(Long id);
}
