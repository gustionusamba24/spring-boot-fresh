package com.gustionusamba.bookcatalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookQueryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6304995450300986556L;

    private Long id;

    private String bookId;

    private String bookTitle;

    private String bookDescription;

    private String publisherName;
}
