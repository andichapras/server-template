package com.example.servertemplate.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.servertemplate.model.Student;
import com.example.servertemplate.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepository studentRepo;

	public ArrayList<Student> getAllStudent(){
		return (ArrayList<Student>) studentRepo.findAll();
	}
	
	public Optional<Student> getStudent(long id) {
		return studentRepo.findById(id);
	}
	
	public Student saveStudent(Student studentReq) {
		return studentRepo.save(studentReq);
	}
	
	public void deleteStudent(long id) {
		studentRepo.deleteById(id);
	}
}
