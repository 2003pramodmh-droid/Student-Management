package com.tap.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tap.entity.Student;
import com.tap.exception.StudentNotFoundException;
import com.tap.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}

	public Student getStudentById(int id) {
		return studentRepo.findById(id)
		 .orElseThrow(() -> new StudentNotFoundException("Student not found with id " + id));
	}

	public Student updateStudent(int id, Student student) {
		 Student existing = getStudentById(id);
		    existing.setName(student.getName());
		    existing.setEmail(student.getEmail());
		    existing.setAge(student.getAge());
		    existing.setCourse(student.getCourse());
		    return studentRepo.save(existing);
	}

	public String deleteStudentById(int id) {
		studentRepo.deleteById(id);
		return "Deleted";
	}

}
