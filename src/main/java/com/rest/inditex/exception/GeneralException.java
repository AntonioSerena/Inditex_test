package com.rest.inditex.exception;

public class GeneralException extends Exception {
    private final String message;

    public GeneralException(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
