package com.examregistration.examregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examregistration.examregistration.entities.Student;
import com.examregistration.examregistration.services.StudentService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/")
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.getAllStudents());
    }
    
    @PostMapping("/createStudent")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.createStudent(student));
    }

    @PutMapping("/enrollSubject/{subjectName}/{rollNo}")
    public ResponseEntity<?> enrollSubject(@PathVariable("subjectName") String subjectName, @PathVariable("rollNo") String rollNo) {
        Integer roll = Integer.parseInt(rollNo);
        Student student = studentService.enrollInSubject(subjectName, roll);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(student);
    }

    @PutMapping("/enrollExam/{examId}/{rollNo}")
    public ResponseEntity<?> enrollExam(@PathVariable("examId") String examString, @PathVariable("rollNo") String rollString) {
        Integer rollNo = Integer.parseInt(rollString);
        Long examId = Long.parseLong(examString);
        Student student = studentService.enrollInExam(examId, rollNo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(student);
    }
    
}
