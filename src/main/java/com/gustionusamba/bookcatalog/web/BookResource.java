package com.gustionusamba.bookcatalog.web;

import com.gustionusamba.bookcatalog.dto.BookCreateDTO;
import com.gustionusamba.bookcatalog.dto.BookDetailDTO;
import com.gustionusamba.bookcatalog.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@AllArgsConstructor
@RestController
public class BookResource {

    private final BookService bookService;

    @GetMapping("/book/{bookId}")
    public BookDetailDTO findBookDetail(@PathVariable("bookId") Long id) {
        BookDetailDTO result = bookService.findBookDetailById(id);
        return result;
    }

    @PostMapping("/book")
    public ResponseEntity<Void> createANewBook(@RequestBody BookCreateDTO dto) {
        bookService.createNewBook(dto);
        return ResponseEntity.created(URI.create("/book")).build();
    }
}
