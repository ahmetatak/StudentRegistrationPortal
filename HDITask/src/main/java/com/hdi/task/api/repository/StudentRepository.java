package com.hdi.task.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdi.task.api.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
 	
 
	public StudentEntity findByStudentEmail(String studentEmail);
	public StudentEntity findByStudentId(int studentId);

}
