package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.domain.Author;
import com.gustionusamba.bookcatalog.dto.AuthorCreateDTO;
import com.gustionusamba.bookcatalog.dto.AuthorResponseDTO;
import com.gustionusamba.bookcatalog.dto.AuthorUpdateDTO;

import java.util.List;

public interface AuthorService {

    AuthorResponseDTO findAuthorById(String id);

    void createNewAuthor(List<AuthorCreateDTO> dto);

    void updateAuthor(String authorId, AuthorUpdateDTO dto);

    void deleteAuthor(String authorId);

    List<Author> findAuthors(List<String> authorIdList);
}
