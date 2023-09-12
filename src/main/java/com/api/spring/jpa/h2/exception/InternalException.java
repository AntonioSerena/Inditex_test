package com.api.spring.jpa.h2.exception;

public class InternalException extends Exception {
    private final String message;

    public InternalException(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
