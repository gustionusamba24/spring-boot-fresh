package com.gustionusamba.bookcatalog.config;

import com.gustionusamba.bookcatalog.domain.Author;
import com.gustionusamba.bookcatalog.domain.Book;
import com.gustionusamba.bookcatalog.repository.BookRepository;
import com.gustionusamba.bookcatalog.repository.impl.BookRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public Author author() {
        return new Author(1L, "Pramoedya Ananta Toer", null, false);
    }

    @Bean
    public Book book1(Author author) {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Bumi Manusia");
        book.setDescription("Bumi Manusia adalah salah satu Novel karya Pramoedya Ananta Toer");
        book.setAuthor(author);
        return book;
    }

    @Bean
    public Book book2(Author author) {
        Book book = new Book();
        book.setId(2L);
        book.setTitle("Arok Dedes");
        book.setDescription("Arok Dedes adalah salah satu Novel karya Pramoedya Ananta Toer");
        book.setAuthor(author);
        return book;
    }

    @Bean
    public BookRepository bookRepository(Book book1, Book book2) {
        Map<Long, Book> bookMap = new HashMap<>();
        bookMap.put(1L, book1);
        bookMap.put(2L, book2);

        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        bookRepository.setBookMap(bookMap);

        return bookRepository;
    }
}
