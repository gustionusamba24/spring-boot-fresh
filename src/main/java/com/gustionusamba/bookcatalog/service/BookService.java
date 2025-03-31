package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.dto.*;

import java.util.List;

public interface BookService {

    BookDetailDTO findBookDetailById(String bookId);

    List<BookDetailDTO> findBookListDetail();

    void createNewBook(BookCreateDTO dto);

    void updateBook(Long bookId, BookUpdateDTO dto);

    void deleteBook(Long bookId);

    ResultPageResponseDTO<BookListResponseDTO> findBookList(Integer page, Integer limit, String sortBy,
                                                            String direction, String publisherName, String bookTitle, String authorName);
}
