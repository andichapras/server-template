package com.example.servertemplate.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.servertemplate.model.Student;
import com.example.servertemplate.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	public StudentService studentService;
	
	
	@GetMapping("/")
	public ArrayList<Student> getAllStudent(){
		return studentService.getAllStudent();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable long id) {
		System.out.println(studentService.getStudent(id));
		if(studentService.getStudent(id).isPresent()) {
			return ResponseEntity.ok(studentService.getStudent(id).get());			
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public void addStudent(@RequestBody Student studentReq) {
		studentService.addStudent(studentReq);
	}
	
	@PutMapping("/")
	public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student studentReq){
		Optional<Student> optStudent = studentService.getStudent(id);
		
		if(optStudent.isPresent()) {
			Student studentObj = optStudent.get();
			studentObj.setName(studentReq.getName());
			studentObj.setAge(studentReq.getAge());
			studentObj.setMajor(studentReq.getMajor());
			
			return ResponseEntity.ok(studentObj);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
		if(studentService.getStudent(id).isPresent()) {
			studentService.deleteStudent(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
