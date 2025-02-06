package com.gustionusamba.bookcatalog.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class BookDetailDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1014381538832257095L;

    private Long bookId;

    private String bookTitle;

    private String bookDescription;

    private String authorName;
}
