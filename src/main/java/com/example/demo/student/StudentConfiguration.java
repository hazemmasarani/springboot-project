package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class StudentConfiguration {
    
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return _ -> {
            Student john = new Student(
                null,
                "John",
                "john@gmail.com",
                LocalDate.of(2000, 1, 1),
                23
            );

            Student alex = new Student(
                null,
                "Alex",
                "alex@gmail.com",
                LocalDate.of(2004, 5, 5),
                21
            );

            studentRepository.saveAll(
                List.of(john, alex)
            ); 
        };
    }
}
