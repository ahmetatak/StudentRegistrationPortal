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

import com.hdi.task.api.entity.CourseEntity;
import com.hdi.task.api.entity.StudentEntity;
import com.hdi.task.api.service.CourseService;
 
import com.hdi.task.helper.ResponseHelper;

@RestController
public class CourseController {
	
	@Autowired  
	CourseService courseService; 
	
	@GetMapping("v1/course")
	private ResponseEntity getAllCourses()
	{
		List<CourseEntity> listOfCourses= courseService.getAllCourses();
		
		if(listOfCourses.size()<=0)
		{
			return new ResponseHelper
		    		(false,
		    		"NotExist",
		    		"Course List is not exist!",
		    		"Course table is empty" )
		    		.build(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseHelper
		    		(true,
		    		"listOfCourses",
		    		"Course List!",
		    		"all Course in database" ,listOfCourses)
		    		.build(HttpStatus.OK);
		}
		//long countByName(String name);
		
	  
	}
	
	@GetMapping("v1/course/{course_id}")  
	private ResponseEntity getStudent(@PathVariable("course_id") int courseId)   
	{  
		if(!courseService.searchStudentByInt(courseId))
		{	return new ResponseHelper
	    		(false,
	    	    		"dataNotExist",
	    	    		"The course cannot be display",
	    	    		"course is not exist in db check your id and try again" )
	    	    		.build(HttpStatus.NOT_FOUND);
			
		}else {
			List<CourseEntity> course = new ArrayList<CourseEntity>();
			course.add(courseService.getCourseById(courseId));
			return new ResponseHelper
		    		(true,
		    		"findCourse",
		    		"Course Found!",
		    		"the couse is exist in db" ,course)
		    		.build(HttpStatus.OK);
		}
	 
	}  
	@PostMapping("v1/course")  
	private ResponseEntity saveStudent(@RequestBody CourseEntity courseEntity)   
	{  
		if(!courseService.searchCourse(courseEntity))
		{
		 courseService.addCourse(courseEntity) ; 
		 List<CourseEntity> course=new ArrayList<CourseEntity>();
		 course.add(courseEntity);
			return new ResponseHelper
            		(	true,
		            		"success",
		            		"inserted",
		            		"A new Course added successfully",
		            		course )
            		.build(HttpStatus.CREATED);
		}
		else {
			
			return new ResponseHelper
            		(false,
            		"dataExist",
            		"Course Cannot be inserted",
            		"Course is exist in database try another one " )
            		.build(HttpStatus.BAD_REQUEST);
	 
		}
 
	}
	
	@PutMapping("v1/course") 
	private ResponseEntity update(@RequestBody CourseEntity  courseEntity)
	{
	 //first of lets check if user exist
		if(courseEntity==null)
			return new ResponseHelper
	        		(false,
	        		"emptForm",
	        		"Update Failed",
	        		"form data cannot be empty" )
	        		.build(HttpStatus.BAD_REQUEST);
		
		if(courseService.searchCourseById(courseEntity))
			
		{
			if(
			   courseEntity.getCourseId()<=0
			|| courseEntity.getCourseQuota()<=0
			|| courseEntity.getCourseName().equals("")
			|| courseEntity.getCourseCode().equals("")
	
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
				 
				courseService.update(courseEntity);
				List<CourseEntity> listStudent = new ArrayList<CourseEntity>();
				listStudent.add(courseEntity);
				
				return new ResponseHelper
		        		(true,
		        		"updatedCourse",
		        		"Update Success!",
		        		"Course information updated successfully" ,
		        		listStudent)
		        		.build(HttpStatus.OK);
				
			}
			
	

			
		}else
		return new ResponseHelper
        		(false,
        		"dataNotExist",
        		"course cannot be modify",
        		"Course is not exist! " )
        		.build(HttpStatus.NOT_FOUND);
	}

	
	@DeleteMapping("v1/course/{courseId}")  
	private ResponseEntity deleteCourse(@PathVariable("courseId") int courseId)   
	{  
	
	
	if(courseId<=0)
		return new ResponseHelper
	    		(false,
	    		"undefinedID",
	    		"Failed deleting the student",
	    		"student id must be integer bigger than 0" )
	    		.build(HttpStatus.BAD_REQUEST);
	
	if(courseService.searchStudentByInt(courseId))
	{
		courseService.delete(courseId);
		return new ResponseHelper
	    		(true,
	    		"deletedStudent",
	    		"Course deleted",
	    		"Course deleted successfully" )
	    		.build(HttpStatus.OK);
		
	}else
	return new ResponseHelper
    		(false,
    		"dataNotExist",
    		"Course cannot be deleted",
    		"Course is not exist in db check your id and try again" )
    		.build(HttpStatus.BAD_REQUEST);
	} 
	
}
