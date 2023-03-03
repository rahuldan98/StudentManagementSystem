package com.org.studentmanagementsystem.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.org.studentmanagementsystem.dto.AdminDto;
import com.org.studentmanagementsystem.models.Admin;
import com.org.studentmanagementsystem.repository.IAdminRepository;
import com.org.studentmanagementsystem.service.IAdminService;

public class AdminServiceImpl implements IAdminService {
	private IAdminRepository adminRepository;
	
	@Autowired
	public AdminServiceImpl(IAdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	@Override
	public Admin register(AdminDto admindto) {
		Admin admin;
		adminRepository.save(admin);
		return null;
	}

	@Override
	public Admin login(AdminDto admindto) {
		// TODO Auto-generated method stub
		return null;
	}

}
