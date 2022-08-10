package com.hdi.task.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdi.task.api.entity.CourseAvailableEntity;
import com.hdi.task.api.entity.CourseEntity;
import com.hdi.task.api.entity.StudentEntity;

public interface CourseAvailableRepository extends JpaRepository<CourseAvailableEntity, Integer>{
 	
	public CourseAvailableEntity findByCourseAvailableId(int courseAvailableId);
	public CourseAvailableEntity findByCourseId(int courseId);
	
}
