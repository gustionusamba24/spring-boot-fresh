package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.domain.Author;
import com.gustionusamba.bookcatalog.dto.AuthorCreateDTO;
import com.gustionusamba.bookcatalog.dto.AuthorResponseDTO;
import com.gustionusamba.bookcatalog.dto.AuthorUpdateDTO;

import java.util.List;
import java.util.Map;

public interface AuthorService {

    AuthorResponseDTO findAuthorById(String id);

    void createNewAuthor(List<AuthorCreateDTO> dto);

    void updateAuthor(String authorId, AuthorUpdateDTO dto);

    void deleteAuthor(String authorId);

    List<Author> findAuthors(List<String> authorIdList);

    List<AuthorResponseDTO> constructDTO(List<Author> authors);

    Map<Long, List<String>> findAuthorMaps(List<Long> bookIdList);
}
