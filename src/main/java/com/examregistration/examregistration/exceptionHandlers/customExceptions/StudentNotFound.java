package com.examregistration.examregistration.exceptionHandlers.customExceptions;

import com.examregistration.examregistration.entities.Student;

public class StudentNotFound extends RuntimeException{
    
    public StudentNotFound(String message) {
        super(message);
    }
}
