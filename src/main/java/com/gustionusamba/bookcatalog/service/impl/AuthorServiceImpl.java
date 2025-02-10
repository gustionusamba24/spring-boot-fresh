package com.gustionusamba.bookcatalog.service.impl;

import com.gustionusamba.bookcatalog.dto.AuthorResponseDTO;
import com.gustionusamba.bookcatalog.repository.AuthorRepository;
import com.gustionusamba.bookcatalog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponseDTO findAuthorById(Long id) {
        // TODO:
        // 1. fetch data from database
        // 2. map the data to AuthorResponseDTO
        return null;
    }
}
