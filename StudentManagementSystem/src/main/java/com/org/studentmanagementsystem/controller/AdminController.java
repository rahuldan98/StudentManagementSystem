package com.org.studentmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.studentmanagementsystem.exception.DuplicateAdminException;
import com.org.studentmanagementsystem.models.Admin;
import com.org.studentmanagementsystem.service.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	private IAdminService adminservice;
	
	@Autowired
	public AdminController(IAdminService adminservice) {
		super();
		this.adminservice = adminservice;
	}
	@PostMapping("/register")
	public ResponseEntity<Admin>register(@RequestBody Admin admin) throws DuplicateAdminException{
		Admin adminResult = adminservice.register(admin);
		
		return new ResponseEntity<>(adminResult,HttpStatus.OK);
	}
	@GetMapping("/login")
	public ResponseEntity<Admin>login ( @RequestBody Admin admin){
		Admin adminResult=adminservice.login(admin);
		return new ResponseEntity<>(adminResult,HttpStatus.OK);
	}
	
}
