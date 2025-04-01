package com.gustionusamba.bookcatalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
public class CategoryQueryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -466866398214310434L;

    private Long bookId;

    private String categoryCode;
}
