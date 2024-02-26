package com.effigo.learningportal.dto;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.effigo.learningportal.model.CourseEntity;
import com.effigo.learningportal.model.EnrollmentEntity;
import com.effigo.learningportal.model.FavouritesEntity;
import com.effigo.learningportal.model.RolesEntity;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;

	private RolesEntity role;

	private String name;

	private String email;

	private BigInteger phoneNumber;

	private boolean status;

	private String password;

	private List<CourseEntity> publishedCourses;

	private List<FavouritesEntity> favourites;

	private List<EnrollmentEntity> enrollments;

	private Date createdAt;

	private Date updatedAt;
}
