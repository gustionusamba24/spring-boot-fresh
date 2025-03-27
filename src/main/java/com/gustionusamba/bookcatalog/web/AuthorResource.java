package com.gustionusamba.bookcatalog.web;

import com.gustionusamba.bookcatalog.dto.AuthorCreateDTO;
import com.gustionusamba.bookcatalog.dto.AuthorResponseDTO;
import com.gustionusamba.bookcatalog.dto.AuthorUpdateDTO;
import com.gustionusamba.bookcatalog.service.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
public class AuthorResource {

    private final AuthorService authorService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/v1/author/{id}/detail")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(authorService.findAuthorById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/v1/author")
    public ResponseEntity<Void> createANewAuthor(@RequestBody @Valid List<AuthorCreateDTO> dto) {
        authorService.createNewAuthor(dto);
        return ResponseEntity.created(URI.create("/author")).build();
    }

    @PutMapping("/v1/author/{authorId}")
    public ResponseEntity<Void> updateAuthor(@PathVariable("authorId") String authorId,
                                             @RequestBody AuthorUpdateDTO dto) {
        authorService.updateAuthor(authorId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/author/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable("authorId") String authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok().build();
    }
}
