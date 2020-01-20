package com.company.exception;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(String firstName){
        super("Person with first Name "+firstName+" is not found.");
    }
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
