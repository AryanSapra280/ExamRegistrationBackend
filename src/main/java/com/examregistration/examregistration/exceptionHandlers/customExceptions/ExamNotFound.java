package com.examregistration.examregistration.exceptionHandlers.customExceptions;


public class ExamNotFound extends RuntimeException {
    public ExamNotFound(String msg) {
        super(msg);
    }
}
