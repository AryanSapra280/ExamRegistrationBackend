package com.examregistration.examregistration.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String name;
    private Integer rollNo;
    @ManyToMany
    List<Subject>subjects = new ArrayList<>();
    @ManyToMany
    List<Exam>exams = new ArrayList<>();

    
    public Student() {
    }

    
    public Student(Long studentId, String name, List<Subject> subjects, List<Exam> exams,Integer rollNo) {
        this.studentId = studentId;
        this.name = name;
        this.subjects = subjects;
        this.exams = exams;
        this.rollNo = rollNo;
    }


    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
    public List<Exam> getExams() {
        return exams;
    }
    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }


    public Integer getRollNo() {
        return rollNo;
    }


    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    
}
