package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.dto.AuthorResponseDTO;

public interface AuthorService {

    public AuthorResponseDTO findAuthorById(Long id);
}
