package com.gustionusamba.bookcatalog.dto;

import com.gustionusamba.bookcatalog.enums.ErrorCode;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ErrorResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 8899773600824301815L;

    private Date timestamp;

    private String message;

    private ErrorCode errorCode;

    private List<String> details;

    private HttpStatus status;

    public ErrorResponseDTO(String message, ErrorCode errorCode, List<String> details, HttpStatus status) {
        super();
        this.message = message;
        this.errorCode = errorCode;
        this.details = details;
        this.status = status;
        this.timestamp = new Date();
    }

    public static ErrorResponseDTO of(final String message, List<String> details, final ErrorCode errorCode, HttpStatus httpStatus) {
        return new ErrorResponseDTO(message, errorCode, details, httpStatus);
    }
}
