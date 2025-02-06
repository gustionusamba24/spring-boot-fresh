package com.gustionusamba.bookcatalog.domain;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Book implements Serializable {

    @Serial
    private static final long serialVersionUID = -4883238118080083787L;

    private Long id;

    private String title;

    private String description;

    private Author author;
}
