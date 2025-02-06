package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.dto.BookDetailDTO;

public interface BookService {

    public BookDetailDTO findBookDetailById(Long bookId);
}
