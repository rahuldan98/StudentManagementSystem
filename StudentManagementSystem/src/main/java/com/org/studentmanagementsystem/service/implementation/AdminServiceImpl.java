package com.org.studentmanagementsystem.service.implementation;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.org.studentmanagementsystem.exception.DuplicateAdminException;
import com.org.studentmanagementsystem.exception.InvalidAdminException;
import com.org.studentmanagementsystem.models.Admin;
import com.org.studentmanagementsystem.repository.IAdminRepository;
import com.org.studentmanagementsystem.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {
	private IAdminRepository adminRepository;

	
	public AdminServiceImpl(IAdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

	@Override
	public Admin register(Admin admin) throws DuplicateAdminException {

		Optional<Admin> optionalAdmin = adminRepository.findByUsername(admin.getUsername());

		if (optionalAdmin.isPresent())
			throw new DuplicateAdminException("Duplicate admin present");

			return adminRepository.save(admin);

	}

	@Override
	public Admin login(Admin admin) {

			Example<Admin> exampleAdmin = Example.of(admin);  //converts admin Entity into Example
			Optional<Admin>optionalAdmin=adminRepository.findOne(exampleAdmin);  // findOne()-->searches for admin entity/ object in the database but
																								//it takes admin entity in the form of Example
			
			if(optionalAdmin.isEmpty())
				throw new InvalidAdminException ("Admin not found");
			return optionalAdmin.get();
	}

}
