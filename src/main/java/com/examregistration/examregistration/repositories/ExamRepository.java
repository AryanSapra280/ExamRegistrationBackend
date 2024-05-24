package com.examregistration.examregistration.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examregistration.examregistration.entities.Exam;


@Repository
public interface ExamRepository extends JpaRepository<Exam,Long>{
    
    Optional<Exam> getExamByExamId(Long id);
    void deleteExamByExamId(Long id);
}
