package com.gustionusamba.bookcatalog.repository;

import com.gustionusamba.bookcatalog.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    @Query("SELECT b FROM Book b INNER JOIN Publisher p ON p.id = b.publisher.id "
            + "WHERE LOWER(p.name) LIKE LOWER(CONCAT('%',:publisherName,'%')) AND LOWER(b.title) LIKE LOWER(CONCAT('%',:bookTitle,'%'))")
    Page<Book> findBookList(String bookTitle, String publisherName, Pageable pageable);
}
