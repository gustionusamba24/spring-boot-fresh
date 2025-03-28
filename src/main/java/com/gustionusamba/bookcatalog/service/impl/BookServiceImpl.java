package com.gustionusamba.bookcatalog.service.impl;

import com.gustionusamba.bookcatalog.domain.Author;
import com.gustionusamba.bookcatalog.domain.Book;
import com.gustionusamba.bookcatalog.domain.Category;
import com.gustionusamba.bookcatalog.domain.Publisher;
import com.gustionusamba.bookcatalog.dto.BookCreateDTO;
import com.gustionusamba.bookcatalog.dto.BookDetailDTO;
import com.gustionusamba.bookcatalog.dto.BookUpdateDTO;
import com.gustionusamba.bookcatalog.exception.BadRequestException;
import com.gustionusamba.bookcatalog.repository.BookRepository;
import com.gustionusamba.bookcatalog.service.AuthorService;
import com.gustionusamba.bookcatalog.service.BookService;
import com.gustionusamba.bookcatalog.service.CategoryService;
import com.gustionusamba.bookcatalog.service.PublisherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service("bookService")
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final AuthorService authorService;

    private final CategoryService categoryService;

    private final PublisherService publisherService;

    @Override
    public BookDetailDTO findBookDetailById(String bookId) {
        log.info("=== start get data book ===");
        Book book = bookRepository.findBySecureId(bookId).orElseThrow(() -> new BadRequestException("Invalid book id"));
        log.info("=== finish get data book ===");

        BookDetailDTO dto = new BookDetailDTO();
        dto.setBookId(book.getSecureId());

        log.info("=== start get data category ===");
        dto.setCategories(categoryService.constructDTO(book.getCategories()));
        log.info("=== finish get data category ===");

        log.info("=== start get data author ===");
        dto.setAuthors(authorService.constructDTO(book.getAuthors()));
        log.info("=== finish get data author ===");

        log.info("=== start get data publisher ===");
        dto.setPublisher(publisherService.constructDTO(book.getPublisher()));
        log.info("=== finish get data publisher ===");

        dto.setBookTitle(book.getTitle());
        dto.setBookDescription(book.getDescription());
        // dto.setAuthorName(book.getAuthor().getName());
        return dto;
    }

    @Override
    public List<BookDetailDTO> findBookListDetail() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map(book -> {
            BookDetailDTO dto = new BookDetailDTO();
            dto.setBookId(book.getSecureId());
            dto.setBookTitle(book.getTitle());
            dto.setBookDescription(book.getDescription());
            // dto.setAuthorName(book.getAuthor().getName());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void createNewBook(BookCreateDTO dto) {
        List<Author> authors = authorService.findAuthors(dto.getAuthorIdList());
        List<Category> categories = categoryService.findCategories(dto.getCategoryList());
        Publisher publisher = publisherService.findPublisher(dto.getPublisherId());

        Book book = new Book();
        book.setAuthors(authors);
        book.setCategories(categories);
        book.setPublisher(publisher);
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
