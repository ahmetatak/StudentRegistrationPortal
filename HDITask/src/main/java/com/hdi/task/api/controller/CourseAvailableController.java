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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hdi.task.api.entity.CourseAvailableEntity;
import com.hdi.task.api.entity.CourseEntity;
import com.hdi.task.api.service.CourseAvailableService;
import com.hdi.task.api.service.CourseService;
import com.hdi.task.helper.ResponseHelper;

@RestController
public class CourseAvailableController {

	@Autowired  
	CourseAvailableService courseAvailableService; 
	
	@Autowired
	CourseService courseService;
	
	@GetMapping("v1/course/available")
	private ResponseEntity get()
	{
		List<CourseAvailableEntity> listOfCourse = courseAvailableService.getAllCourses();
		if(listOfCourse.size()<=0)
		{
			return new ResponseHelper
		    		(false,
		    		"NotExist",
		    		"Course List is not exist!",
		    		"Course table is empty" )
		    		.build(HttpStatus.NOT_FOUND);
		}else {
			
			//List<CourseEntity> courses=this.modifList(listOfCourse);
			return new ResponseHelper
		    		(true,
		    		"listOfCourses",
		    		"Course List!",
		    		"All Coursess Available " ,listOfCourse)
		    		.build(HttpStatus.OK);
		}
		//long countByName(String name);
		
	}
	
	 
	
	@PostMapping("v1/course/available") 
	private ResponseEntity add(@RequestBody CourseAvailableEntity courseAvailableEntity)   
	{  
		if(courseService.searchStudentByInt(courseAvailableEntity.getCourseId()))
		{
		
		 
		 //now we need to check if id is not exist in course available table
		 
		 if(courseAvailableService.searchCourseByInt(courseAvailableEntity.getCourseId()))
		 {
				return new ResponseHelper
	            		(	false,
			            		"dataExist",
			            		"Insert Failed",
			            		"Data is allready exist in database."
			            	 )
	            		.build(HttpStatus.BAD_REQUEST); 
		 }else {
		
			 courseAvailableService.addCourse(courseAvailableEntity) ; 
			 List<CourseAvailableEntity> course=new ArrayList<CourseAvailableEntity>();
			 course.add(courseAvailableEntity);
				return new ResponseHelper
	            		(	true,
			            		"success",
			            		"inserted",
			            		"A new Course added successfully",
			            		course )
	            		.build(HttpStatus.CREATED); 
		}

		}
		else {
			
			return new ResponseHelper
            		(false,
            		"dataNOTExist",
            		"Course Cannot be inserted",
            		"Course is NOT exinst in database try another one " )
            		.build(HttpStatus.NOT_FOUND);
	 
		}
 
	}
	
	@DeleteMapping("v1/course/available/{courseAvailableId}")  
	private ResponseEntity deleteCourse(@PathVariable("courseAvailableId") int courseAvailableId)   
	{  
	
	
	if(courseAvailableId<=0)
		return new ResponseHelper
	    		(false,
	    		"undefinedID",
	    		"Failed deleting the student",
	    		"couse id must be integer bigger than 0" )
	    		.build(HttpStatus.BAD_REQUEST);
 
	if(courseAvailableService.searchCourseAvailableById(courseAvailableId))
	{
		//courseAvailableService.delete(courseAvailableId);
		
	courseAvailableService.delete(courseAvailableId);
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
