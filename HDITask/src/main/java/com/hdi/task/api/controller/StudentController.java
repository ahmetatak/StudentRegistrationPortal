package com.hdi.task.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hdi.task.api.entity.StudentEntity;
import com.hdi.task.api.service.StudentService;
import com.hdi.task.helper.ResponseHelper;

@RestController
public class StudentController {

	@Autowired  
	StudentService studentService;  
	
	@GetMapping("v1/student")
	private ResponseEntity getAllStudents()
	{
		List<StudentEntity> listStudent= studentService.getAllStudent();
		
		if(listStudent.size()<=0)
		{
			return new ResponseHelper
		    		(false,
		    		"NotExist",
		    		"Student List is not exist!",
		    		"student table is empty" )
		    		.build(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseHelper
		    		(true,
		    		"listOfStudent",
		    		"Student List!",
		    		"all student in database" ,listStudent)
		    		.build(HttpStatus.OK);
		}
		//long countByName(String name);
		
	  
	}
	
	@GetMapping("v1/student/{id}")  
	private ResponseEntity getStudent(@PathVariable("id") int student_id)   
	{  
		if(!studentService.searchStudentByInt(student_id))
		{	return new ResponseHelper
	    		(false,
	    	    		"dataNotExist",
	    	    		"The student cannot be display",
	    	    		"Thestudent is not exist in db check your id and try again" )
	    	    		.build(HttpStatus.NOT_FOUND);
			
		}else {
			List<StudentEntity> student = new ArrayList<StudentEntity>();
			student.add(studentService.getStudentById(student_id));
			return new ResponseHelper
		    		(true,
		    		"findStudent",
		    		"Student Found!",
		    		"the student is exist in db" ,student)
		    		.build(HttpStatus.OK);
		}
	 
	}  
	
	@PostMapping("v1/student")  
	private ResponseEntity saveStudent(@RequestBody StudentEntity studentEntity)   
	{  StudentEntity newRequest= new StudentEntity();
	newRequest.setStudentName(studentEntity.getStudentName());
	newRequest.setStudentSurname(studentEntity.getStudentSurname());
	newRequest.setStudentPassword(studentEntity.getStudentPassword());
	newRequest.setStudentEmail(studentEntity.getStudentEmail());
	newRequest.setDepartmentId(studentEntity.getDepartmentId());
 
		if(!studentService.searchStudentByEmail(newRequest))
		{
			studentService.addStudent(newRequest);  
		 List<StudentEntity> student=new ArrayList<StudentEntity>();
		 student.add(studentEntity);
			return new ResponseHelper
            		(	true,
		            		"success",
		            		"inserted",
		            		"A new Student added successfully",
		            		student )
            		.build(HttpStatus.CREATED);
			
		 
		}
		else {
			
			return new ResponseHelper
            		(false,
            		"dataExist",
            		"student cannot be inserted",
            		"user email address is exist in database try another one " )
            		.build(HttpStatus.BAD_REQUEST);
	 
		}
 
	}
	 
	@PutMapping("v1/student/") 
	private ResponseEntity update(@RequestBody StudentEntity studentEntity)
	{
	 //first of lets check if user exist
		if(studentEntity==null)
			return new ResponseHelper
	        		(false,
	        		"emptForm",
	        		"Update Failed",
	        		"form data cannot be empty" )
	        		.build(HttpStatus.BAD_REQUEST);
		
		if(studentService.searchStudentById(studentEntity))
			
		{
			if(
			studentEntity.getDepartmentId()<=0
			|| studentEntity.getStudentId()<=0
			|| studentEntity.getStudentEmail().equals("")
			|| studentEntity.getStudentName().equals("")
			|| studentEntity.getStudentSurname().equals("")
			|| studentEntity.getStudentPassword().equals("")
		 )
			{
				
				return new ResponseHelper
		        		(false,
		        		"DataMissing",
		        		"Update Failed",
		        		"form data cannot be empty" )
		        		.build(HttpStatus.BAD_REQUEST);
				

				
			}else
				
			{
				 
				studentService.update(studentEntity);
				List<StudentEntity> listStudent = new ArrayList<StudentEntity>();
				listStudent.add(studentEntity);
				
				return new ResponseHelper
		        		(true,
		        		"updatedStudent",
		        		"Update Success!",
		        		"user information updated successfully" ,
		        		listStudent)
		        		.build(HttpStatus.OK);
				
			}
			
	

			
		}else
		return new ResponseHelper
        		(false,
        		"dataNotExist",
        		"student cannot be modify",
        		"Student is not exist! " )
        		.build(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("v1/student/{id}")  
	private ResponseEntity deleteStudent(@PathVariable("id") int student_id)   
	{  
	
	
	if(student_id<=0)
		return new ResponseHelper
	    		(false,
	    		"undefinedID",
	    		"Failed deleting the student",
	    		"student id must be integer bigger than 0" )
	    		.build(HttpStatus.BAD_REQUEST);
	
	if(studentService.searchStudentByInt(student_id))
	{
		studentService.delete(student_id);
		return new ResponseHelper
	    		(true,
	    		"deletedStudent",
	    		"student deleted",
	    		"student deleted successfully" )
	    		.build(HttpStatus.OK);
		
	}else
	return new ResponseHelper
    		(false,
    		"dataNotExist",
    		"student cannot be deleted",
    		"student is not exist in db check your id and try again" )
    		.build(HttpStatus.BAD_REQUEST);
	} 
	
	 
}
