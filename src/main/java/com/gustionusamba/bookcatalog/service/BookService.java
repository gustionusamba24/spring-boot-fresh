package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.dto.BookCreateDTO;
import com.gustionusamba.bookcatalog.dto.BookDetailDTO;
import com.gustionusamba.bookcatalog.dto.BookUpdateDTO;

import java.util.List;

public interface BookService {

    BookDetailDTO findBookDetailById(Long bookId);

    List<BookDetailDTO> findBookListDetail();

    void createNewBook(BookCreateDTO dto);

    void updateBook(Long bookId, BookUpdateDTO dto);

    void deleteBook(Long bookId);
}
