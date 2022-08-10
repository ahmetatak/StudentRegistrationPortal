package com.hdi.task.helper;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseHelper {
	private boolean statu;
	private String code;
	private String title;
	private String message;
	private List<?> data;
	public boolean isStatu() {
		return statu;
	}
	public void setStatu(boolean statu) {
		this.statu = statu;
	}
	public ResponseHelper(boolean statu, String code, String title, String message) {
		super();
		this.statu = statu;
		this.code = code;
		this.title = title;
		this.message = message;
 
	}
	public ResponseHelper(boolean statu, String code, String title, String message,List<?> data) {
		super();
		this.statu = statu;
		this.code = code;
		this.title = title;
		this.message = message;
		this.data=data;
 
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}

 public ResponseEntity build(HttpStatus httpStatus)
 {
	 
	 return ResponseEntity
	            .status(httpStatus)
	            .body(this);
 }

}
