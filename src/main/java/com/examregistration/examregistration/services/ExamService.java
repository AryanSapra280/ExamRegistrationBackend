package com.examregistration.examregistration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examregistration.examregistration.entities.Exam;
import com.examregistration.examregistration.entities.Subject;
import com.examregistration.examregistration.exceptionHandlers.customExceptions.ExamNotFound;
import com.examregistration.examregistration.exceptionHandlers.customExceptions.SubjectNotFound;
import com.examregistration.examregistration.repositories.ExamRepository;

@Service
public class ExamService {
    
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private SubjectService subjectService;
    
    public Exam createExam(String subjectName) {
        Exam exam = new Exam();
        Subject subject = subjectService.getSubjectByName(subjectName);
        exam.setSubject(subject);
        return examRepository.save(exam);
    }
    public List<Exam> getExams() {
        return examRepository.findAll();
    }
    public Exam getExamById(Long id) {
        Optional<Exam>optional = examRepository.getExamByExamId(id);
        if(optional.isEmpty()) {
            throw new ExamNotFound("Exam doesn't exist");
        }
        return optional.get();
    }
    public void deleteExamById(Long id) {
        Exam exam = getExamById(id);
        examRepository.delete(exam);
    }
}
