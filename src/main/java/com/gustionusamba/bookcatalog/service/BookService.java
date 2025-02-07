package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.dto.BookDetailDTO;

import java.util.List;

public interface BookService {

    public BookDetailDTO findBookDetailById(Long bookId);

    public List<BookDetailDTO> findBookListDetail();
}
