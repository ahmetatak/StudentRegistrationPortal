package com.hdi.task.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdi.task.api.entity.StudentEntity;
import com.hdi.task.api.service.StudentService;

@RestController
public class DefaultController {
	
	@Autowired  
	StudentService studentService;  
	
	@GetMapping("/")
	private List<StudentEntity>  getAllStudents()
	{
		
		  return studentService.getAllStudent();  
	}

}
