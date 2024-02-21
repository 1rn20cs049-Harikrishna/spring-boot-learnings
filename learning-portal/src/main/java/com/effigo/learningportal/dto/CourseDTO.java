package com.effigo.learningportal.dto;

import java.sql.Date;
import java.util.List;

import com.effigo.learningportal.model.EnrollmentEntity;
import com.effigo.learningportal.model.FavouritesEntity;

import lombok.Data;

@Data
public class CourseDTO {

	private Long id;
	private String name;
	private Long courseCategoryId;
	private Long publisherId;
	private List<EnrollmentEntity> enrollments; // Assuming you want to represent enrollment IDs
	private List<FavouritesEntity> favourites;
	private Date createdAt;
	private Date updatedAt;
	private boolean status;

	// Constructors, getters, and setters
}
