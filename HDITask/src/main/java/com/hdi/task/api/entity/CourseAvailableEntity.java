package com.hdi.task.api.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "COURSE_AVAILABLE")

public class CourseAvailableEntity implements Serializable{
	@Id  
	@Column  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int courseAvailableId;

	@Column 
private int courseId;

	@OneToMany()
    @JoinColumn(name = "courseId", referencedColumnName = "courseId",updatable = false)
 	private List<CourseEntity> courseEntities;
 
 

	public List<CourseEntity> getCourseEntities() {
		return courseEntities;
	}

	public void setCourseEntities(List<CourseEntity> courseEntities) {
		this.courseEntities = courseEntities;
	}

	public int getCourseAvailableId() {
		return courseAvailableId;
	}

	public void setCourseAvailableId(int courseAvailableId) {
		this.courseAvailableId = courseAvailableId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	} 
	
	
 

}
