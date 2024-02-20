package com.effigo.learningportal.model;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true)
	private String name;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "course_category_id")
	private CourseCategoryEntity courseCategory;

	@OneToMany(mappedBy = "course")
	private Set<EnrollmentEntity> enrollments;

	@ManyToOne
    @JoinColumn(name = "publisher_id")
    private UserEntity publisher;
	
	@OneToMany(mappedBy = "course")
    private List<FavouritesEntity> favourites;


	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(nullable = false)
	private boolean status;

//	public void setName(String name) {
//		this.name = name;
//		
//	}

	
}







