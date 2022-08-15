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
import com.hdi.task.api.entity.CourseSelectedEntity;
import com.hdi.task.api.entity.StudentEntity;
import com.hdi.task.api.repository.CourseRepository;
import com.hdi.task.api.service.CourseAvailableService;
import com.hdi.task.api.service.CourseService;
import com.hdi.task.api.service.StudentService;
import com.hdi.task.api.service.CourseSelectedService;
import com.hdi.task.helper.ResponseHelper;

@RestController
public class CourseSelectedController {
	@Autowired
	CourseSelectedService courseSelectedService; 
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseAvailableService courseAvailableService;
	
	@Autowired  
	CourseService courseService; 
	@GetMapping("v1/course/selected/")
	private ResponseEntity getAll()
	{
		
	 
			List<CourseSelectedEntity> listOfCourses= courseSelectedService.getAll();
	 
			if(listOfCourses.size()<=0)
			{
				return new ResponseHelper
			    		(false,
			    		"NotExist",
			    		"Course List is not exist!",
			    		"Course selected table is empty" )
			    		.build(HttpStatus.NOT_FOUND);
			}else {
	 
				return new ResponseHelper
			    		(true,
			    		"listOfCourses",
			    		"Course List!",
			    		"All Selected Courses in database" ,listOfCourses)
			    		.build(HttpStatus.OK);
			}
		
		
		//long countByName(String name);
		
	  
	}
	@GetMapping("v1/course/selected/{studentId}")
	private ResponseEntity getOne(@PathVariable("studentId") int studentId)
	{
		
		if(!studentService.searchStudentByInt(studentId))
		{	return new ResponseHelper
	    		(false,
	    	    		"dataNotExist",
	    	    		"The student cannot be display",
	    	    		"Thestudent is not exist in db check your id and try again" )
	    	    		.build(HttpStatus.NOT_FOUND);
			
		}else {
			List<CourseSelectedEntity> listOfCourses= courseSelectedService.getStudentById(studentId);
	 
			if(listOfCourses.size()<=0)
			{
				return new ResponseHelper
			    		(false,
			    		"NotExist",
			    		"Course List is not exist!",
			    		"Course selected table is empty" )
			    		.build(HttpStatus.NOT_FOUND);
			}else {
	 
				return new ResponseHelper
			    		(true,
			    		"listOfCourses",
			    		"Course List!",
			    		"" ,listOfCourses)
			    		.build(HttpStatus.OK);
			}
		}
		
		//long countByName(String name);
		
	  
	}
	
	@PostMapping("v1/course/selected/{studentId}")
	private ResponseEntity insert(@RequestBody List<CourseSelectedEntity> courseSelectedEntity, @PathVariable("studentId") int studentId)
	{
		if(!studentService.searchStudentByInt(studentId))
		{	return new ResponseHelper
	    		(false,
	    	    		"dataNotExist",
	    	    		"The student cannot be display",
	    	    		"Thestudent is not exist in db check your id and try again" )
	    	    		.build(HttpStatus.NOT_FOUND);
			
		}else {
 			int count=0;
			for (CourseSelectedEntity course : courseSelectedEntity) {
			int courseId=	course.getCourseId();

			// lets check if the course id exist in database;
			// CourseService will be called in this part.
			if(!courseService.searchStudentByInt(courseId))
			{
				return new ResponseHelper
			    		(false,
			    	    		"dataNotExist",
			    	    		"The course cannot be display",
			    	    		"course is not exist in db check your id and try again" )
			    	    		.build(HttpStatus.NOT_FOUND);
				
			}
			//if course is exist than lets check the quota
			CourseEntity getCourse= courseService.getCourseById(courseId);
			
			 
			long countTotali=getCourse.getCourseQuota();
			String courseName=getCourse.getCourseName();
			String courseCode=getCourse.getCourseCode();
			
			 CourseAvailableEntity courseAvailableEntity= courseAvailableService.findByCourseId(getCourse.getCourseId());
			
			 
			 //let check if course can be available
			 
			 
			 if(courseAvailableEntity==null)
					return new ResponseHelper
				    		(false,
				    		"notSelected",
				    		"Failed to select the course",
				    		"Course is not in available list"
				    		)
				    		.build(HttpStatus.BAD_REQUEST);
				//lets count selected course
				 
			long countSelected=courseSelectedService.count(getCourse.getCourseId());
			 //if the course cannot be selected 
			 
				
			if(countSelected>=countTotali)
			{
				
				//gibin course detail
				List<CourseEntity> currentCourse=new ArrayList<CourseEntity>();
				currentCourse.add(getCourse);
				return new ResponseHelper
			    		(false,
			    		"notSelected",
			    		"Failed to select the course",
			    		"Course cannot be selected ",currentCourse
			    		)
			    		.build(HttpStatus.BAD_REQUEST);
			}else {
				
				//if student is already selected the course 
				List<CourseSelectedEntity> search=courseSelectedService.find(studentId,courseId );
 
				for (CourseSelectedEntity searchResult : search) {
					if(!(searchResult==null))
						 return new ResponseHelper
						    		(false,
						    		"AllreadySelected",
						    		"Selected Allready!",
						    		"Student is already selected the course."
						    		)
						    		.build(HttpStatus.BAD_REQUEST);
				}
				
				//there is no problem so student can select the course
		 
			
				CourseSelectedEntity model = new CourseSelectedEntity();
		 
				model.setCourseId(courseId);
				model.setStudentId(studentId);
				if(!(model==null))
				courseSelectedService.add(model);
				count++;
			}
 
			}
			if(count>0)
				return new ResponseHelper
			    		(true,
			    		"selectedCourse",
			    		"Selection Course Successfuly!",
			    		"Total "+count+" courses selected!"
			    		)
			    		.build(HttpStatus.BAD_REQUEST);
			else {
				return new ResponseHelper
			    		(false,
			    		"notSelected",
			    		"Failed to select the course",
			    		 "none course selected "
			    		)
			    		.build(HttpStatus.BAD_REQUEST);
			}
		}
	}
	
	
	@DeleteMapping("v1/course/selected/{studentId}")
	private ResponseEntity delete(@RequestBody List<CourseSelectedEntity> courseSelectedEntity, @PathVariable("studentId") int studentId)
	{
		if(!studentService.searchStudentByInt(studentId))
		{	return new ResponseHelper
	    		(false,
	    	    		"dataNotExist",
	    	    		"The student cannot be display",
	    	    		"Thestudent is not exist in db check your id and try again" )
	    	    		.build(HttpStatus.NOT_FOUND);
			
		}else {
			//this step will delete multiple course on selected table
			int count=0;
			for (CourseSelectedEntity course : courseSelectedEntity) {
			int courseId=	course.getCourseId();
			// lets check if course exist in database.
			List<CourseSelectedEntity> search=courseSelectedService.find(studentId,courseId );
			if(search==null)
			{
				//no need response
			}
			else {
				 for (CourseSelectedEntity searchResult : search) {
					 courseSelectedService.delete(searchResult.getCourseSelectedId());
						count++;
				}
				
			}
			}
			
			if(count>0)
			return new ResponseHelper
		    		(true,
		    		"listOfCourses",
		    		"Course List!",
		    		"list deleted successfuly!" )
		    		.build(HttpStatus.OK);
			else {
				return new ResponseHelper
			    		(false,
			    		"notDeleted",
			    		"Failed to delete data",
			    		"please be sure which id your entered" )
			    		.build(HttpStatus.BAD_REQUEST);
			}
			
		}
	}
 
 
}
