package com.examregistration.examregistration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examregistration.examregistration.entities.Exam;
import com.examregistration.examregistration.entities.Student;
import com.examregistration.examregistration.entities.Subject;
import com.examregistration.examregistration.exceptionHandlers.customExceptions.StudentIsNotEnrolledInSubject;
import com.examregistration.examregistration.exceptionHandlers.customExceptions.StudentNotFound;
import com.examregistration.examregistration.repositories.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ExamService examService;

    @Autowired
    private SubjectService subjectService;
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    public Student enrollInSubject(String subjectName,Integer rollNo) {
        Student student = getStudentByRollNo(rollNo);
        Subject subject = subjectService.getSubjectByName(subjectName);
        student.getSubjects().add(subject);
        return createStudent(student);
        
    }
    public Student getStudentByRollNo(Integer rollNo) {
        Optional<Student> optional = studentRepository.findByRollNo(rollNo);
        if(optional.isEmpty()) {
            throw new StudentNotFound("Student with this roll no doesn't exisit");
        }
        return optional.get();
    }
    public Student enrollInExam(Long examId,Integer rollNo) {
        Student student = getStudentByRollNo(rollNo);
        Exam exam = examService.getExamById(examId);
        boolean studentEnrolledInExamOrNot = student.getSubjects().stream().anyMatch((sub)->sub.equals(exam.getSubject()));
        if(!studentEnrolledInExamOrNot) {
            throw new StudentIsNotEnrolledInSubject("Student is not enrolled in the Subject");
        }
        student.getExams().add(exam);
        return createStudent(student);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
