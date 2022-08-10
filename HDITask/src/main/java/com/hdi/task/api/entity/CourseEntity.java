package com.hdi.task.api.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "COURSE")
public class CourseEntity {
	
	@Id  
	@Column  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int courseId;

	@Column( length = 100) 
private String courseName; 
	@Column( length = 100) 
private String courseCode; 
	@Column 
private int courseQuota;
	public int getCourseId() {
		return courseId;
	}
	
 
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public int getCourseQuota() {
		return courseQuota;
	}
	public void setCourseQuota(int courseQuota) {
		this.courseQuota = courseQuota;
	} 
 

}
