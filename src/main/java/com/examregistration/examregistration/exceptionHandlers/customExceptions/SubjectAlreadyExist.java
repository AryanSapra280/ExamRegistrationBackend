package com.examregistration.examregistration.exceptionHandlers.customExceptions;

public class SubjectAlreadyExist extends RuntimeException {
    public SubjectAlreadyExist(String message) {
        super(message);
    }
}
