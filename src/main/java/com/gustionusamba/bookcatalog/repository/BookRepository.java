package com.gustionusamba.bookcatalog.repository;

import com.gustionusamba.bookcatalog.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

//    Book findBookById(Long id);
//
//    List<Book> findAll();
//
//    void save(Book book);
//
//    void update(Book book);
//
//    void delete(Long id);


    @Override
    Optional<Book> findById(Long id);

    Optional<Book> findBySecureId(String bookId);
}
