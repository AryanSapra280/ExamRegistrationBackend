package com.examregistration.examregistration.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examregistration.examregistration.entities.Student;
import com.examregistration.examregistration.entities.Subject;
import com.examregistration.examregistration.exceptionHandlers.customExceptions.SubjectAlreadyExist;
import com.examregistration.examregistration.exceptionHandlers.customExceptions.SubjectNotFound;
import com.examregistration.examregistration.repositories.SubjectRepository;


@Service
public class SubjectService {
    
    @Autowired
    private SubjectRepository subjectRepository;
    
    public List<Subject>getSubjects() {
        return subjectRepository.findAll();
    }
    public Subject createSubject(Subject subject) {
        if(isSubjectExist(subject.getSubjectName())) {
            throw new SubjectAlreadyExist(subject.getSubjectName() + " Subject already exisit");
        }
        return  subjectRepository.save(subject);
    }
    
    private boolean isSubjectExist(String subjectName) {
        return   subjectRepository.findAll().stream().anyMatch((sub)->sub.getSubjectName().equals(subjectName));
    }
    public Subject getSubjectByName(String subjectName) {
        Optional<Subject>optional = subjectRepository.findBySubjectName(subjectName);
        if(optional.isEmpty()) {
            throw new SubjectAlreadyExist(subjectName + " doesn't exist");
        }
        return optional.get();
    }
    public void deleteExamByName(String name) {
        Subject subject = getSubjectByName(name);
        subjectRepository.delete(subject);
    }
  
}
