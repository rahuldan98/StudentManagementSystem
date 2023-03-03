package com.org.studentmanagementsystem.service;

import org.springframework.stereotype.Service;

import com.org.studentmanagementsystem.dto.AdminDto;
import com.org.studentmanagementsystem.models.Admin;

@Service
public interface IAdminService {
	public Admin register(AdminDto admindto);
	public Admin login(AdminDto admindto);
	
}
