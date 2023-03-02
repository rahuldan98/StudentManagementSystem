package com.org.studentmanagementsystem.dto;

import javax.persistence.ManyToOne;

import com.org.studentmanagementsystem.models.Student;

public class CourseDto {
	private Integer id;
	private String name;
		
	public CourseDto(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CourseDto [id=" + id + ", name=" + name + "]";
	}
	
	
}
