package com.examregistration.examregistration.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examregistration.examregistration.entities.Subject;



@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long>{
    
    Optional<Subject> findBySubjectName(String name);
}
