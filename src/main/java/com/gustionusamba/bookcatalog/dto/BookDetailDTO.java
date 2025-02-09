package com.gustionusamba.bookcatalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookDetailDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1014381538832257095L;

    private Long bookId;

    private String bookTitle;

    private String bookDescription;

    private String authorName;
}
