package com.gustionusamba.bookcatalog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookCreateDTO {

    @NotBlank
    private String bookTitle;

    private String bookDescription;

    @NotBlank
    private String authorName;
}
