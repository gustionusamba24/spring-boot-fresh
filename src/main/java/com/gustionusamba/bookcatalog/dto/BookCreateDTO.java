package com.gustionusamba.bookcatalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookCreateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 7713172881022627856L;

    @NotBlank
    private String bookTitle;

    private String bookDescription;

    @NotEmpty
    private List<String> authorIdList;

    @NotEmpty
    private List<String> categoryList;

    @NotBlank
    private String publisherId;
}
