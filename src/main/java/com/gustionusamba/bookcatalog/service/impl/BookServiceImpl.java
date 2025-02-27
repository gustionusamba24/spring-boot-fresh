package com.gustionusamba.bookcatalog.service.impl;

import com.gustionusamba.bookcatalog.domain.Author;
import com.gustionusamba.bookcatalog.domain.Book;
import com.gustionusamba.bookcatalog.dto.BookCreateDTO;
import com.gustionusamba.bookcatalog.dto.BookDetailDTO;
import com.gustionusamba.bookcatalog.dto.BookUpdateDTO;
import com.gustionusamba.bookcatalog.exception.BadRequestException;
import com.gustionusamba.bookcatalog.repository.BookRepository;
import com.gustionusamba.bookcatalog.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service("bookService")
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookDetailDTO findBookDetailById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BadRequestException("Invalid book id"));
        BookDetailDTO dto = new BookDetailDTO();
        dto.setBookId(book.getId());
        dto.setBookTitle(book.getTitle());
        dto.setBookDescription(book.getDescription());
//        dto.setAuthorName(book.getAuthor().getName());
        return dto;
    }

    @Override
    public List<BookDetailDTO> findBookListDetail() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(book -> {
            BookDetailDTO dto = new BookDetailDTO();
            dto.setBookId(book.getId());
            dto.setBookTitle(book.getTitle());
            dto.setBookDescription(book.getDescription());
//            dto.setAuthorName(book.getAuthor().getName());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void createNewBook(BookCreateDTO dto) {
        Author author = new Author();
        author.setName(dto.getAuthorName());

        Book book = new Book();
//        book.setAuthor(author);
        book.setTitle(dto.getBookTitle());
        book.setDescription(dto.getBookDescription());
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Long bookId, BookUpdateDTO dto) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BadRequestException("Invalid book id"));
        book.setTitle(dto.getBookTitle());
        book.setDescription(dto.getBookDescription());
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
