package com.examregistration.examregistration.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.examregistration.examregistration.entities.Student;
import com.examregistration.examregistration.exceptionHandlers.customExceptions.ExamNotFound;
import com.examregistration.examregistration.exceptionHandlers.customExceptions.NullSubject;
import com.examregistration.examregistration.exceptionHandlers.customExceptions.StudentIsNotEnrolledInSubject;
import com.examregistration.examregistration.exceptionHandlers.customExceptions.StudentNotFound;
import com.examregistration.examregistration.exceptionHandlers.customExceptions.SubjectAlreadyExist;
import com.examregistration.examregistration.exceptionHandlers.customExceptions.SubjectNotFound;


/**
 * GlobalExceptionHandlers
 */
@ControllerAdvice
public class GlobalExceptionHandlers {

    @ExceptionHandler(SubjectAlreadyExist.class)
    public ResponseEntity<?>subjectAlreadyExist(SubjectAlreadyExist subjectAlreadyExisit) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(subjectAlreadyExisit.getMessage());
    }

    @ExceptionHandler(SubjectNotFound.class)
    public ResponseEntity<?>subjectNotFound(SubjectNotFound subjectNotFound) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(subjectNotFound.getMessage());
    }

    @ExceptionHandler(NullSubject.class) 
    public ResponseEntity<?>nullSubject(NullSubject nullSubject) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(nullSubject.getMessage());
    }
    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<?>studentNotFound(StudentNotFound studentNotFound) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(studentNotFound.getMessage());
    }   
    @ExceptionHandler(ExamNotFound.class)
    public ResponseEntity<?>studentNotFound(ExamNotFound examNotFound) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(examNotFound.getMessage());
    }   
    @ExceptionHandler(StudentIsNotEnrolledInSubject.class)
    public ResponseEntity<?>studentNotFound(StudentIsNotEnrolledInSubject studentIsNotEnrolledInSubject) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(studentIsNotEnrolledInSubject.getMessage());
    }   
}