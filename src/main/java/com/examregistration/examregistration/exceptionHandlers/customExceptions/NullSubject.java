package com.examregistration.examregistration.exceptionHandlers.customExceptions;

public class NullSubject extends RuntimeException{
    public NullSubject(String msg) {
        super(msg);
    }
}
