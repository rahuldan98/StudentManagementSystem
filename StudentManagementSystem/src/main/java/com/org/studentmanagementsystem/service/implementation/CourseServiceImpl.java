package com.org.studentmanagementsystem.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.studentmanagementsystem.exception.CourseNotFoundException;
import com.org.studentmanagementsystem.models.Course;
import com.org.studentmanagementsystem.repository.ICourseRepository;
import com.org.studentmanagementsystem.service.ICourseService;

@Service
public class CourseServiceImpl implements ICourseService {
	
	private ICourseRepository courseRepository;
	
	@Autowired
	public CourseServiceImpl(ICourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	@Override
	public Course create(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	@Override
	public Course view(Integer id) {
		// TODO Auto-generated method stub
		return courseRepository.findById(id).orElseThrow(()-> new CourseNotFoundException("course not found")) ;
	}

	@Override
	public List<Course> viewAll() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	@Override
	public Course update(Integer id, Course course) {
		// TODO Auto-generated method stub
		 return courseRepository.findById(id).orElseThrow(()-> new CourseNotFoundException("Course not found")).setName(course.getName());
		}

	@Override
	public Course delete(Integer id) {
		// TODO Auto-generated method stub
		Optional<Course> optionalcourse = Optional.ofNullable(courseRepository.findById(id)
				.orElseThrow(()-> new CourseNotFoundException("course not found")));
		courseRepository.deleteById(id);
		return optionalcourse.get();
		
	}
	

}
