package com.examregistration.examregistration.exceptionHandlers.customExceptions;

public class StudentIsNotEnrolledInSubject extends RuntimeException {
    public StudentIsNotEnrolledInSubject(String msg) {
        super(msg);
    }
}
