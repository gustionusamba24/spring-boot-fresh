package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.dto.BookCreateDTO;
import com.gustionusamba.bookcatalog.dto.BookDetailDTO;
import com.gustionusamba.bookcatalog.dto.BookUpdateDTO;

import java.util.List;

public interface BookService {

    public BookDetailDTO findBookDetailById(Long bookId);

    public List<BookDetailDTO> findBookListDetail();

    public void createNewBook(BookCreateDTO dto);

    public void updateBook(Long bookId, BookUpdateDTO dto);
}
