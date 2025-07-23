package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

	@Autowired
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

    // This method simulates fetching all students from a data source
    public List<Student> getAllStudents() {
		return studentRepository.findAll();	
    }

	public Student getStudentById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Student with id " + id + " does not exist"));
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository.findStudentsByEmail(student.getEmail());
		if (studentOptional.isPresent()) {
			throw new IllegalStateException("Email already taken");
		}
		studentRepository.save(student);
	}

	public void deleteStudent(Long id) {
		if (!studentRepository.existsById(id)) {
			throw new IllegalStateException("Student with id " + id + " does not exist");
		}
		studentRepository.deleteById(id);
	}

	@Transactional
	public void updateStudent(Long id, Student student) {
		if (!studentRepository.existsById(id)) {
			throw new IllegalStateException("Student with id " + id + " does not exist");
		}
		student.setId(id);
		studentRepository.save(student);
	}

	public List<Student> findStudentsByName(String name) {
		return studentRepository.findAll().stream()
				.filter(student -> student.getName().equalsIgnoreCase(name))
				.toList();
	}

	public Optional<Student> findStudentsByEmail(String email) {
		return studentRepository.findStudentsByEmail(email);
	}
}
