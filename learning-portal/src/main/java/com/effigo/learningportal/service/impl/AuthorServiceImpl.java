//package com.effigo.learningportal.service.impl;
//
//import org.springframework.stereotype.Service;
//
//import com.effigo.learningportal.dto.CourseDTO;
//import com.effigo.learningportal.mapper.CoursePopulator;
//import com.effigo.learningportal.model.CourseEntity;
//import com.effigo.learningportal.repository.CourseRepository;
//import com.effigo.learningportal.service.AuthorService;
//
//@Service
//public class AuthorServiceImpl implements AuthorService {
//
//	private  CourseRepository courseRepository;
//
//	public AuthorServiceImpl(CourseRepository courseRepository) {
//		super();
//		this.courseRepository = courseRepository;
//	}
//
//	@Override
//	public CourseEntity createCourse(CourseDTO courseDto, Long authorId) {
//		CourseEntity course = CoursePopulator.INSTANCE.CourseDtoToEntity(courseDto);
//		course.setPublisher(authorId);
//		return courseRepository.save(course);
//	}
//
//	@Override
//	public CourseEntity editCourse(CourseEntity course) {
//		return courseRepository.save(course);
//	}
//
//}
