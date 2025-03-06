package com.gustionusamba.bookcatalog.service.impl;

import com.gustionusamba.bookcatalog.domain.Author;
import com.gustionusamba.bookcatalog.dto.AuthorCreateDTO;
import com.gustionusamba.bookcatalog.dto.AuthorResponseDTO;
import com.gustionusamba.bookcatalog.dto.AuthorUpdateDTO;
import com.gustionusamba.bookcatalog.exception.BadRequestException;
import com.gustionusamba.bookcatalog.repository.AuthorRepository;
import com.gustionusamba.bookcatalog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponseDTO findAuthorById(String id) {
        // TODO:
        // 1. fetch data from database
        Author author = authorRepository.findBySecureId(id).orElseThrow(() -> new BadRequestException("Invalid author ID"));
        // 2. map the data to AuthorResponseDTO
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setAuthorName(author.getName());
        dto.setBirthDate(author.getBirthDate().toEpochDay());
        return dto;
    }

    @Override
    public void createNewAuthor(List<AuthorCreateDTO> dtos) {

        List<Author> authors = dtos.stream().map((dto) -> {
            Author author = new Author();
            author.setName(dto.getAuthorName());
            author.setBirthDate(LocalDate.ofEpochDay(dto.getBirthDate()));
            return author;
        }).collect(Collectors.toList());

        authorRepository.saveAll(authors);
    }

    @Override
    public void updateAuthor(String authorId, AuthorUpdateDTO dto) {
        Author author = authorRepository.findBySecureId(authorId)
                .orElseThrow(() -> new BadRequestException("Invalid author ID"));
        author.setName(dto.getAuthorName() == null ? author.getName() : dto.getAuthorName());
        author.setBirthDate(
                dto.getBirthDate() == null ? author.getBirthDate() : LocalDate.ofEpochDay(dto.getBirthDate()));

        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(String authorId) {
//        authorRepository.deleteById(authorId);
        Author author = authorRepository.findBySecureId(authorId)
                .orElseThrow(() -> new BadRequestException("Invalid author ID"));
        authorRepository.delete(author);

        // soft delete
//        Author author = authorRepository.findByIdAndDeletedFalse(authorId).orElseThrow(() -> new BadRequestException("Invalid author id"));
//        author.setDeleted(Boolean.TRUE);
//        authorRepository.save(author);
    }
}
