package com.gustionusamba.bookcatalog.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AddressCreateRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4177814055057635505L;

    private String streetName;

    private String cityName;

    private String zipCode;
}
