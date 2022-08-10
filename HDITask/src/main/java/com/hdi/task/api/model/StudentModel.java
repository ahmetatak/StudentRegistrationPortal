package com.hdi.task.api.model;

import java.util.List;

import javax.persistence.Column;

import com.hdi.task.api.entity.StudentEntity;

public class StudentModel {
 
	private int student_id;
	 
	private String student_name; 
 
	private String student_surname; 
 
	private String student_email; 
 
 
 
	private int department_id; 
	
	
	public StudentModel( List<StudentEntity> studentEntity)
	{
		
		
	}
	
	

}
