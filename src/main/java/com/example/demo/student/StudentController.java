package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
	public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // @GetMapping("/{id}")
    // public Student getStudentById(Long id) {
    //     return studentService.getStudentById(id);
    // }    

    // @PostMapping("/add")
    // public void addNewStudent(Student student) {
    //     studentService.addNewStudent(student);
    // }

    // @PostMapping("/delete/{id}")
    // public void deleteStudent(Long id) {
    //     studentService.deleteStudent(id);
    // }

    // @PostMapping("/update/{id}")
    // public void updateStudent(Long id, Student student) {
    //     studentService.updateStudent(id, student);
    // }

    // @GetMapping("/search")
    // public List<Student> findStudentsByName(String name) {
    //     return studentService.findStudentsByName(name);
    // }

}
