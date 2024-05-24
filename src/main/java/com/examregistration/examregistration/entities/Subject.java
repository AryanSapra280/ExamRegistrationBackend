package com.examregistration.examregistration.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;
    private String subjectName;
    @ManyToMany(mappedBy = "subjects",cascade =  CascadeType.ALL)
    @JsonIgnore
    private List<Student>students =new ArrayList<>();
    @JsonIgnore
    @OneToOne(mappedBy = "subject",cascade =  CascadeType.ALL)
    private Exam exam;
    
    public Subject() {
    }
    
    public Subject(Long subjectId, String subjectName, List<Student> students, Exam exam) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.students = students;
        this.exam = exam;
    }

    public Long getSubjectId() {
        return subjectId;
    }
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public Exam getExam() {
        return exam;
    }
    public void setExam(Exam exam) {
        this.exam = exam;
    }
    
}
