package com.main.app.exceptions;

public class APIException extends RuntimeException {
    public APIException(String message) {
        super(message);
    }
}
