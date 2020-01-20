package com.company.exception;

public class InputValidationException extends RuntimeException {

    public InputValidationException(String firstName){
        super("Input value must comply with API specification.");
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
