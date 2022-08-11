package com.hdi.task.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdi.task.api.entity.CourseEntity;
import com.hdi.task.api.entity.CourseSelectedEntity;
import com.hdi.task.api.entity.StudentEntity;
import com.hdi.task.api.repository.CourseSelectedRepository;

@Service
public class CourseSelectedService {
	@Autowired
	CourseSelectedRepository courseSelectedRepository;
	public List<CourseSelectedEntity> getAll()
	{
		List<CourseSelectedEntity> listOfCourse = new ArrayList<CourseSelectedEntity>();  
		courseSelectedRepository.findAll().forEach(course -> listOfCourse.add(course));
		
		return listOfCourse;
	}
	
	//Get specific  by id;
	public List<CourseSelectedEntity> getStudentById(int studentId)   
	{  
	return courseSelectedRepository.findByStudentId(studentId);
	} 
	//Search byInt
	public List<CourseSelectedEntity> find(int studentId, int courseId)   
	{  
		 
		return courseSelectedRepository.findByStudentIdAndCourseId(studentId,courseId);
	 
  
	}
	public long count( int courseId)   
	{  
		 
		return courseSelectedRepository.countByCourseId(courseId);
	 
  
	}
	
	//remove course
	public void delete(int id)   
	{  
		courseSelectedRepository.deleteById(id);  
	}  
	
	//Add a  new course
	public void add(CourseSelectedEntity courseEntity)   
	{  
		courseSelectedRepository.save(courseEntity);  
	} 
}
