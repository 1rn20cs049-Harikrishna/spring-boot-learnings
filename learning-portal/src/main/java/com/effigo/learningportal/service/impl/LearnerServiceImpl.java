//package com.effigo.learningportal.service.impl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.stereotype.Service;
//
//import com.effigo.learningportal.model.CourseEntity;
//import com.effigo.learningportal.model.FavouritesEntity;
//import com.effigo.learningportal.model.UserEntity;
//import com.effigo.learningportal.repository.CourseRepository;
//import com.effigo.learningportal.repository.FavouritesRepository;
//import com.effigo.learningportal.repository.UserRepository;
//import com.effigo.learningportal.service.LearnerService;
//
//@Service
//public  class LearnerServiceImpl implements LearnerService {
//	private CourseRepository courseRepository;
//
//	private UserRepository userRepository;
//
//	private FavouritesRepository favouritesRepository;
//
//	public LearnerServiceImpl(CourseRepository courseRepository, UserRepository userRepository,
//			FavouritesRepository favouritesRepository) {
//		this.courseRepository = courseRepository;
//		this.userRepository = userRepository;
//		this.favouritesRepository = favouritesRepository;
//	}
//
//	@Override
//	public List<CourseEntity> searchCourseById(Long courseId) {
//
//		return courseRepository.findAllCourseById(courseId);
//
//	}
//
////	@Override
////	public List<CourseEntity> searchCourseByAuthor(Long authorId) {
////		Optional<CourseEntity> courseOptional = courseRepository.findAllCourseByAuthorId(authorId);
////
////        return (List<CourseEntity>) courseOptional.orElse(null);
////	}
//
//	@Override
//	public List<CourseEntity> searchCourseByCategory(Long id) {
//
//		return null;
//	}
//
//	@Override
//	public String addFavourite(Long uid, Long cid) {
//
//		/*
//		 * Three things should be checked that is user present or not ,course * present
//		 * or not and whether is user is already added favorite
//		 */
//
//		Optional<UserEntity> userOptional = userRepository.getUserById(uid);
//
//		if (userOptional.isEmpty()) {
//			return "User not found";
//		}
//
//		// Check if the course is present
//		Optional<CourseEntity> courseOptional = courseRepository.findById(cid);
//		if (courseOptional.isEmpty()) {
//			return "Course not found";
//		}
//
//		Optional<FavouritesEntity> existingFavourite = favouritesRepository.findByUserIdAndCourseId(uid, cid);
//		if (existingFavourite.isPresent()) {
//			return "Course is already added to favorites by the user";
//		}
//
//		// If all checks pass, add the course to favorites for the user
//		UserEntity user = userOptional.get();
//		CourseEntity course = courseOptional.get();
//
//		FavouritesEntity favourite = new FavouritesEntity();
//		favourite.setUser(user);
//		favourite.setCourse(course);
//
//		favouritesRepository.save(favourite);
//
//		return "Course added to favorites successfully";
//
//	}
//
//	@Override
//	public String enrollCourse(Long uid, Long cid) {
//
//		return null;
//	}
//
//	@Override
//	public List<CourseEntity> getAllFavouriteByUserId(Long uid) {
//
//		return favouritesRepository.findAllByUserId(uid);
//	}
//
//	@Override
//	public List<CourseEntity> searchCourseByAuthor(Long author) {
//	
//		return null;
//	}
//
//
//
//}
