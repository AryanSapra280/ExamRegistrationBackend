package com.examregistration.examregistration.exceptionHandlers.customExceptions;

public class SubjectNotFound extends RuntimeException {
    
    public SubjectNotFound(String mssg) {
        super(mssg);
    }
}
