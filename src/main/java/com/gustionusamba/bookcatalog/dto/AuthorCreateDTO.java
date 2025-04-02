package com.gustionusamba.bookcatalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.gustionusamba.bookcatalog.validator.annotation.ValidAuthorName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AuthorCreateDTO {

    @ValidAuthorName
    @NotBlank
    private String authorName;

    @NotNull
    private Long birthDate;

    @NotEmpty
    private List<AddressCreateRequestDTO> addresses;
}
