package com.examregistration.examregistration.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examregistration.examregistration.entities.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    
        Optional<Student> findByRollNo(Integer rollNo);
}
