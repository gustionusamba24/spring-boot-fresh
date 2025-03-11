package com.gustionusamba.bookcatalog.web;

import com.gustionusamba.bookcatalog.dto.BookCreateDTO;
import com.gustionusamba.bookcatalog.dto.BookDetailDTO;
import com.gustionusamba.bookcatalog.dto.BookUpdateDTO;
import com.gustionusamba.bookcatalog.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
public class BookResource {

    private final BookService bookService;

    @GetMapping("/v1/book/{bookId}")
    public BookDetailDTO findBookDetail(@PathVariable("bookId") String id) {
        return bookService.findBookDetailById(id);

    }

    @PostMapping("/v1/book")
    public ResponseEntity<Void> createANewBook(@RequestBody BookCreateDTO dto) {
        bookService.createNewBook(dto);
        return ResponseEntity.created(URI.create("/book")).build();
    }

    @GetMapping("/v1/book")
    public ResponseEntity<List<BookDetailDTO>> findBookList() {
        return ResponseEntity.ok().body(bookService.findBookListDetail());
    }

    @PutMapping("/v1/book/{bookId}")
    public ResponseEntity<Void> updateBook(@PathVariable("bookId") Long bookId, @RequestBody BookUpdateDTO dto) {
        bookService.updateBook(bookId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/book/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }
}
