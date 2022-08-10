package com.hdi.task.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

 
import com.hdi.task.api.entity.CourseSelectedEntity;

public interface CourseSelectedRepository  extends JpaRepository<CourseSelectedEntity, Integer>{

	public List<CourseSelectedEntity> findByStudentId(int studentId);
	public CourseSelectedEntity findByStudentIdAndCourseId(int studentId, int courseId);
	public List<CourseSelectedEntity> findByCourseId(int courseId);
	
	public long countByCourseId(int courseId); 
	
}
 