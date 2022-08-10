package com.hdi.task.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdi.task.api.entity.CourseAvailableEntity;
import com.hdi.task.api.entity.StudentEntity;
import com.hdi.task.api.repository.CourseAvailableRepository;
 
@Service
public class CourseAvailableService {
	@Autowired
	CourseAvailableRepository courseAvailableRepository;
	
	
	public List<CourseAvailableEntity> getAllCourses()
	{
		List<CourseAvailableEntity> listOfCourse = new ArrayList<CourseAvailableEntity>();  
		courseAvailableRepository.findAll().forEach(course -> listOfCourse.add(course));
		
		return listOfCourse;
	}
	
	//Add a  new course  for student
	public void addCourse(CourseAvailableEntity courseAvailableEntity)   
	{  
		courseAvailableRepository.save(courseAvailableEntity);  
	}  
 
	//Search byInt
	public Boolean searchCourseAvailableById(int id)   
	{  
		 
		CourseAvailableEntity course=courseAvailableRepository.findByCourseAvailableId(id);
		if(course==null)
			return false;
		else 
			return true;
  
	}
	//Search byInt
	public Boolean searchCourseByInt(int courseId)   
	{  
		 
		CourseAvailableEntity course=courseAvailableRepository.findByCourseId(courseId);
		if(course==null)
			return false;
		else 
			return true;
  
	}
	//remove course
	public void delete(int id)   
	{  
		courseAvailableRepository.deleteById(id);  
	}  
}
