package br.com.geolocalization.application.domain.exceptions;

import org.springframework.http.HttpStatus;

public class DefaultException extends RuntimeException {
    private final HttpStatus statusCode;

    public DefaultException() {
        super("Internal error.");
        statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public DefaultException(String message) {
        super(message);
        statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public DefaultException(String message, HttpStatus httpStatus) {
        super(message);
        statusCode = httpStatus;
    }

    public HttpStatus getStatusCode() { return statusCode; }
}