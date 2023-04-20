package com.org.studentmanagementsystem.service;

import org.springframework.stereotype.Service;

import com.org.studentmanagementsystem.exception.DuplicateAdminException;
import com.org.studentmanagementsystem.models.Admin;

@Service
public interface IAdminService {
	public Admin register(Admin admin) throws DuplicateAdminException;
	public Admin login(Admin admin);
	
}
