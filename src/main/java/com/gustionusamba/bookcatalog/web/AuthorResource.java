package com.gustionusamba.bookcatalog.web;

import com.gustionusamba.bookcatalog.dto.AuthorResponseDTO;
import com.gustionusamba.bookcatalog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthorResource {

    private final AuthorService authorService;

    @GetMapping("/author/{id}/detail")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(authorService.findAuthorById(id));
    }
}
