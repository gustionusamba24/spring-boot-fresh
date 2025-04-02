package com.gustionusamba.bookcatalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

//@LogThisArg
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublisherCreateDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4187966152847548820L;

    @NotBlank(message = "publisher.name.must.not.be.blank")
    private String publisherName;

    @NotBlank(message = "company.name.must.not.be.blank")
    private String companyName;

    private String address;
}
