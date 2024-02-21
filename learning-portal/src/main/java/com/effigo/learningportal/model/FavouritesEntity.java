package com.effigo.learningportal.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "favourites")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavouritesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "course_id")
	private CourseEntity course;
	
	
	@Column(name = "created_at")
	@CreationTimestamp
	private Date createdAt;	

	@Column(name = "updated_at")
	@UpdateTimestamp
	private Date updatedAt;
}
