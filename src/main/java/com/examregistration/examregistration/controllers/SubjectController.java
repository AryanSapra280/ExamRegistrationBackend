package com.examregistration.examregistration.controllers;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import com.examregistration.examregistration.entities.Subject;
import com.examregistration.examregistration.services.SubjectService;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/")
    public ResponseEntity<?> getSubjects() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(subjectService.getSubjects());
    }
    
    @PostMapping("/")
    public ResponseEntity<?> addSubject(@RequestBody Subject subject) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(subjectService.createSubject(subject));
    }
    
    @DeleteMapping("/remove/{name}")
    public ResponseEntity<?> deleteExam(@PathVariable("name")String name) {
        subjectService.deleteExamByName(name);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(name + " deleted");
    }
    
}
