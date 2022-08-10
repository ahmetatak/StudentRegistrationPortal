package com.hdi.task.api.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Entity
@Table(name = "STUDENT")
public class StudentEntity implements Serializable {
	//student_id is primary key and defined as primary key 
	@Id  
	@Column 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int studentId;
	@Column( length = 100) 
private String studentName; 
	@Column( length = 100) 
private String studentSurname; 
	@Column( length = 200) 
private String studentEmail; 
	@Column( length = 250) 
private String studentPassword; 
	@Column
private int departmentId; 
	
	
	@OneToMany()
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId",updatable = false)
 
 
 	    private List<DepartmentEntity> departmentList;
	    
    
	public List<DepartmentEntity> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<DepartmentEntity> departmentList) {
		this.departmentList = departmentList;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentSurname() {
		return studentSurname;
	}
	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	 


}
