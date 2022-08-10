package com.hdi.task.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdi.task.api.entity.CourseEntity;
import com.hdi.task.api.entity.StudentEntity;

 

public interface CourseRepository  extends JpaRepository<CourseEntity, Integer>{

	public CourseEntity findByCourseCode(String courseCode);
	public CourseEntity findByCourseId(int courseId);
}
