package com.gustionusamba.bookcatalog.service;

import com.gustionusamba.bookcatalog.dto.AuthorCreateDTO;
import com.gustionusamba.bookcatalog.dto.AuthorResponseDTO;

import java.util.List;

public interface AuthorService {

    public AuthorResponseDTO findAuthorById(Long id);

    public void createNewAuthor(List<AuthorCreateDTO> dto);
}
