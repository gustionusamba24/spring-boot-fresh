package com.gustionusamba.bookcatalog.web;

import com.gustionusamba.bookcatalog.dto.*;
import com.gustionusamba.bookcatalog.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
public class BookResource {

    private final BookService bookService;

    @GetMapping("/v1/book/{bookId}")
    public ResponseEntity<BookDetailDTO> findBookDetail(@PathVariable("bookId") String id) {
        BookDetailDTO result = bookService.findBookDetailById(id);
        return ResponseEntity.ok(result);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/v1/book")
    public ResponseEntity<Void> createANewBook(@RequestBody BookCreateDTO dto) {
        bookService.createNewBook(dto);
        return ResponseEntity.created(URI.create("/book")).build();
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/v2/book")
    public ResponseEntity<ResultPageResponseDTO<BookListResponseDTO>> findBookList(
            @RequestParam(name = "page", required = true, defaultValue = "0") Integer page,
            @RequestParam(name = "limit", required = true, defaultValue = "3") Integer limit,
            @RequestParam(name = "sortBy", required = true, defaultValue = "title") String sortBy,
            @RequestParam(name = "direction", required = true, defaultValue = "asc") String direction,
            @RequestParam(name = "bookTitle", required = false, defaultValue = "") String bookTitle,
            @RequestParam(name = "publisherName", required = false, defaultValue = "") String publisherName,
            @RequestParam(name = "authorName", required = false, defaultValue = "") String authorName
    ) {
        return ResponseEntity.ok().body(bookService.findBookList(page, limit, sortBy, direction, publisherName, bookTitle, authorName));
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
