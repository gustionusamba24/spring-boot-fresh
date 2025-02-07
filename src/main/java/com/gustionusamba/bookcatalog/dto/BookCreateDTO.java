package com.gustionusamba.bookcatalog.dto;

import lombok.Data;

@Data
public class BookCreateDTO {

    private String bookTitle;

    private String bookDescription;

    private String authorName;
}
