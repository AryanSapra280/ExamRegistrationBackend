package com.examregistration.examregistration.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.examregistration.examregistration.entities.Exam;
import com.examregistration.examregistration.services.ExamService;
import com.examregistration.examregistration.services.SubjectService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/exam")
public class ExamController {
    
    @Autowired
    private ExamService examService;

    @GetMapping("/exams")
    public List<Exam> getAllExams() {
        return examService.getExams();
    }
    
    
    @PostMapping("/createExam/{subjectName}")
    public ResponseEntity<?> createExam(@PathVariable("subjectName") String subjectName) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(examService.createExam(subjectName));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<?> removeExam(@PathVariable("id")String id) {
        Long examId = Long.parseLong(id);
        examService.deleteExamById(examId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("exam with " + id + " deleted");
    }
    
}
