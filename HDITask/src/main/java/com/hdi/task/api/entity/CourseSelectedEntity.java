package com.hdi.task.api.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE_SELECTED")
public class CourseSelectedEntity implements Serializable {
	@Id  
	@Column  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int courseSelectedId;

	@Column  
private int courseId;
	@Column  
private int studentId;
 

	@OneToMany()
 
    @JoinColumn(name = "courseId", referencedColumnName = "courseId",updatable = false)
 	private List<CourseEntity> courses;
	
 
	
 
	public List<CourseEntity> getCourses() {
		return courses;
	}
	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}
	public int getCourseSelectedId() {
		return courseSelectedId;
	}
	public void setCourseSelectedId(int courseSelectedId) {
		this.courseSelectedId = courseSelectedId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	 

}
