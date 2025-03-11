package com.gustionusamba.bookcatalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublisherResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8187011936263850914L;

    private String publisherId;

    private String publisherName;
}
