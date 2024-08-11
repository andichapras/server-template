package com.example.servertemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.servertemplate.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
