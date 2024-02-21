package com.effigo.learningportal.runner;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.effigo.learningportal.model.CourseCategoryEntity;
import com.effigo.learningportal.model.CourseEntity;
import com.effigo.learningportal.model.EnrollmentEntity;
import com.effigo.learningportal.model.FavouritesEntity;
import com.effigo.learningportal.model.RolesEntity;
import com.effigo.learningportal.model.UserEntity;
import com.effigo.learningportal.repository.CourseCategoryRepository;
import com.effigo.learningportal.repository.CourseRepository;
import com.effigo.learningportal.repository.EnrollmentRepository;
import com.effigo.learningportal.repository.FavouritesRepository;
import com.effigo.learningportal.repository.RolesRepository;
import com.effigo.learningportal.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class TestRunner implements CommandLineRunner {

	private UserRepository userRepository;

	private RolesRepository rolesRepository;

	private CourseRepository courseRepository;

	private CourseCategoryRepository courseCategoryRepository;

	private FavouritesRepository favouritesRepository;

	private EnrollmentRepository enrollmentRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
//		 boolean v =  enrollmentRepository.existsByUserAndCourse((long) 56,(long) 13);
//		 log.info("Value of v " + v);
		 

//		UserEntity userEntity = new UserEntity();
//		userEntity.setName("hari");
//		userEntity.setEmail("harikrishna92364@gmail.com");
//		userEntity.setPassword("123456");
//		userEntity.setPhoneNumber(75843);

//		userRepository.save(userEntity);
//
//		RolesEntity rolesEntity = new RolesEntity();
//		rolesEntity.setId((long) 1);
//		rolesEntity.setName("ADMIN");
//
//		rolesEntity.se
//
//		RolesEntity rolesEntity2 = new RolesEntity();
//		rolesEntity2.setId((long) 2);
//		rolesEntity2.setName("AUTHOR");
//
//		RolesEntity rolesEntity3 = new RolesEntity();
//		rolesEntity3.setId((long) 3);
//		rolesEntity3.setName("LEARNER");
//
//		rolesRepository.save(rolesEntity);
//		rolesRepository.save(rolesEntity2);
//		rolesRepository.save(rolesEntity3);
//
//		UserEntity userEntity = new UserEntity();
//		userEntity.setName("adfs");
//		userEntity.setRole(rolesEntity3);
//		userRepository.save(userEntity);
//
//		UserEntity userEntity2 = new UserEntity();
//		userEntity.setName("adfs");
//		userEntity.setRole(rolesEntity3);
//		userRepository.save(userEntity);
//
//		CourseEntity courseEntity = new CourseEntity();
//		courseEntity.setId((long) 2);
//		courseEntity.setName("JAVA");
//
//		CourseEntity courseEntity2 = new CourseEntity();
//		courseEntity.setId((long) 6);
//		courseEntity.setName("JAVA");
//
//		courseRepository.save(courseEntity2);

//		EnrollmentEntity enrollmentEntity = new EnrollmentEntity();
////
//		enrollmentEntity.setCourse(courseRepository.findById((long) 13).orElse(null));
//		enrollmentEntity.setUser(userRepository.findById((long) 56).orElse(null));
//		enrollmentRepository.save(enrollmentEntity);

//		FavouritesEntity favouritesEntity = new FavouritesEntity();
//		favouritesEntity.setCourse(courseEntity);
//		favouritesEntity.setUser(userEntity);
//
//		FavouritesEntity favouritesEntity2 = new FavouritesEntity();
//		favouritesEntity2.setCourse(courseEntity2);
//		favouritesEntity2.setUser(userEntity2);
//
//		favouritesRepository.save(favouritesEntity);
//		favouritesRepository.save(favouritesEntity2);
//
//		CourseCategoryEntity courseCategoryEntity = new CourseCategoryEntity();
//		courseCategoryEntity.setId((long) 1);
//		courseCategoryEntity.setName("JAVA");
//		courseCategoryEntity.setStatus(true);
//		courseEntity.setCourseCategory(courseCategoryEntity);
//
//		courseRepository.save(courseEntity);
//
////		courseCategoryRepository.save(courseCategoryEntity);

	}

}
