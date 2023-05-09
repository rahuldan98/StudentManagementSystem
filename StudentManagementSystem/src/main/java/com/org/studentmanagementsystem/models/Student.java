package com.org.studentmanagementsystem.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String username;
	private String password;
	
	@OneToMany(fetch= FetchType.LAZY,cascade=CascadeType.ALL,mappedBy = "student")
	@JsonManagedReference
	private List<Course>courselist;
	
	public Student(Integer id, String username, String password, List<Course> courselist) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.courselist = courselist;
	}
	public Integer getId() {
		return id;
	}
	public Student setId(Integer id) {
		this.id = id;
		return this;
	}
	public String getUsername() {
		return username;
	}
	public Student setUsername(String username) {
		this.username = username;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public Student setPassword(String password) {
		this.password = password;
		return this;
	}
	public List<Course> getCourselist() {
		return courselist;
	}
	public Student setCourselist(List<Course> courselist) {
		this.courselist = courselist;
		return this;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", username=" + username + ", password=" + password + ", courselist=" + courselist
				+ "]";
	}
	
	
}
