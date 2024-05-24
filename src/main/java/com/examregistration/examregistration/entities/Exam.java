package com.examregistration.examregistration.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examId;
    @OneToOne
    private Subject subject;
    @JsonIgnore
    @ManyToMany(mappedBy = "exams",cascade = CascadeType.PERSIST)
    private List<Student>students = new ArrayList<>();

    
    
    public Exam() {
    }
    public Exam(Long examId, Subject subject, List<Student> students) {
        this.examId = examId;
        this.subject = subject;
        this.students = students;
    }
    public Long getExamId() {
        return examId;
    }
    public void setExamId(Long examId) {
        this.examId = examId;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    
}
