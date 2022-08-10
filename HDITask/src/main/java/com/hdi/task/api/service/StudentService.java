package com.hdi.task.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdi.task.api.entity.StudentEntity;
import com.hdi.task.api.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	public List<StudentEntity> getAllStudent()
	{
		List<StudentEntity> listOfStudent = new ArrayList<StudentEntity>();  
		studentRepository.findAll().forEach(student -> listOfStudent.add(student));
		
		return listOfStudent;
	}
	//Get specific student by id;
	public StudentEntity getStudentById(int student_id)   
	{  
	return studentRepository.findById(student_id).get();  
	} 
	
	//remove Student
	public void delete(int student_id)   
	{  
	studentRepository.deleteById(student_id);  
	}  
	
	//Add a  new student
	public void addStudent(StudentEntity studentEntity)   
	{  
	studentRepository.save(studentEntity);  
	}  
	
 
	
	//Search if student exist
	public Boolean searchStudentByEmail(StudentEntity studentEntity)   
	{  
		 
		StudentEntity student=studentRepository.findByStudentEmail(studentEntity.getStudentEmail());
 	 
		if(student==null)
			return false;
		else 
			return true;
  
	}
	
	//Search 
	public Boolean searchStudentById(StudentEntity studentEntity)   
	{  
		 
		StudentEntity student=studentRepository.findByStudentId(studentEntity.getStudentId());
		if(student==null)
			return false;
		else 
			return true;
  
	}
	//Search byInt
		public Boolean searchStudentByInt(int studentId)   
		{  
			 
			StudentEntity student=studentRepository.findByStudentId(studentId);
			if(student==null)
				return false;
			else 
				return true;
	  
		}
	//UpdateStudent
	public void update(StudentEntity studentEntity)   
	{  
	studentRepository.save(studentEntity);  
	}  

}
