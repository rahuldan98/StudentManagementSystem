package com.org.studentmanagementsystem.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.studentmanagementsystem.exception.DuplicateStudentException;
import com.org.studentmanagementsystem.exception.StudentNotFoundException;
import com.org.studentmanagementsystem.models.Student;
import com.org.studentmanagementsystem.repository.IStudentRepository;
import com.org.studentmanagementsystem.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
	private IStudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(IStudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student create(Student student) {
		
		Optional<Student> optionalStudent=studentRepository.findByUsername(student.getUsername());
		
		if(optionalStudent.isPresent())
			throw new DuplicateStudentException("Duplicate Student present");
		
		return studentRepository.save(student);
	}

	@Override
	public Student view(Integer id) {
		
		return studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not found"));
	}

	@Override
	public List<Student> viewAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student update(Integer id, Student student) {
		
		Student updatedstudent= studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Student not found")).setUsername(student.getUsername())
				.setPassword(student.getPassword());
		return studentRepository.save(updatedstudent);
	}

	@Override
	public Student delete(Integer id) {
		
		Optional<Student>optionalStudent = studentRepository.findById(id);
		
		if(optionalStudent.isEmpty())
			throw new StudentNotFoundException("student not found");
		
		studentRepository.deleteById(id);
		return optionalStudent.get();
	}

	@Override
	public Student enrollCourse(Integer studentId, Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student discardCourse(Integer studentId, Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> viewAllStudentByCourse(Integer courseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
