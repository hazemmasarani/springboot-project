package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
    
    Optional<Student> findStudentsByEmail(String email);    

    Optional<Student> findStudentByName(String name);

} 
