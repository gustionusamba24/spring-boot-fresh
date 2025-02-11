package com.gustionusamba.bookcatalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -3197248676665184552L;

    public BadRequestException(String message) {
        super(message);
    }
}
