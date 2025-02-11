package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.dto.AuthorCreateDTO;
import com.gustionusamba.bookcatalog.dto.AuthorResponseDTO;

public interface AuthorService {

    public AuthorResponseDTO findAuthorById(Long id);

    public void createNewAuthor(AuthorCreateDTO dto);
}
