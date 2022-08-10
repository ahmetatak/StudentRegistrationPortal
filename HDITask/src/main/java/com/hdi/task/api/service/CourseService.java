package com.hdi.task.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdi.task.api.entity.CourseEntity;
import com.hdi.task.api.entity.StudentEntity;
import com.hdi.task.api.repository.CourseRepository;
import com.hdi.task.api.repository.StudentRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	public List<CourseEntity> getAllCourses()
	{
		List<CourseEntity> listOfCourse = new ArrayList<CourseEntity>();  
		courseRepository.findAll().forEach(course -> listOfCourse.add(course));
		
		return listOfCourse;
	}
 
	//Search 
	public Boolean searchCourseById(CourseEntity courseEntity)   
	{  
		 
		CourseEntity course=courseRepository.findByCourseId(courseEntity.getCourseId());
		if(course==null)
			return false;
		else 
			return true;
  
	}
	//Get specific course by id;
	public CourseEntity getCourseById(int courseId)   
	{  
	return courseRepository.findById(courseId).get();  
	}
	//Search byInt
	public Boolean searchStudentByInt(int courseId)   
	{  
		 
		CourseEntity course=courseRepository.findByCourseId(courseId);
		if(course==null)
			return false;
		else 
			return true;
  
	}
	//Search if course exist
	public Boolean searchCourse(CourseEntity courseEntity)   
	{  
	 
		CourseEntity course=courseRepository.findByCourseCode(courseEntity.getCourseCode());
 	 
		if(course==null)
			return false;
		else 
			return true;
  
	}
	
	
	//remove course
	public void delete(int courseId)   
	{  
		courseRepository.deleteById(courseId);  
	}  
	
	//Add a  new course
	public void addCourse(CourseEntity courseEntity)   
	{  
		courseRepository.save(courseEntity);  
	}  
	
 
	
 
 
	//UpdateStudent
	public void update(CourseEntity courseEntity)   
	{  
		courseRepository.save(courseEntity);  
	}  

}
