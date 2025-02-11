package com.gustionusamba.bookcatalog.service.impl;

import com.gustionusamba.bookcatalog.domain.Author;
import com.gustionusamba.bookcatalog.dto.AuthorResponseDTO;
import com.gustionusamba.bookcatalog.exception.BadRequestException;
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
        Author author = authorRepository.findById(id).orElseThrow(() -> new BadRequestException("Invalid author ID"));
        // 2. map the data to AuthorResponseDTO
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setAuthorName(author.getName());
        dto.setBirthDate(author.getBirthDate().toEpochDay());
        return dto;
    }
}
