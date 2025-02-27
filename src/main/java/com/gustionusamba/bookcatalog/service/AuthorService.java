package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.dto.AuthorCreateDTO;
import com.gustionusamba.bookcatalog.dto.AuthorResponseDTO;
import com.gustionusamba.bookcatalog.dto.AuthorUpdateDTO;

import java.util.List;

public interface AuthorService {

    AuthorResponseDTO findAuthorById(Long id);

    void createNewAuthor(List<AuthorCreateDTO> dto);

    void updateAuthor(Long authorId, AuthorUpdateDTO dto);

    void deleteAuthor(Long authorId);
}
