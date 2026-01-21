package com.tap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tap.entity.Student;
import com.tap.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
	}
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(student));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));	
	}
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudentByid(@PathVariable("id") int id, @Valid @RequestBody Student student) {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(id,student));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteStudentById(id));
	}
	

}
