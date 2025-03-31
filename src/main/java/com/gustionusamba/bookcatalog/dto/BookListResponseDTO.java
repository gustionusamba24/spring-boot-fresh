package com.gustionusamba.bookcatalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookListResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4928315196862479653L;

    private String bookId;

    private String bookTitle;

    private String bookDescription;

    private String publisherName;

    private List<String> categoryCodes;

    private List<String> authorName;
}
