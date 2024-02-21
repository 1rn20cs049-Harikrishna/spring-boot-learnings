package com.effigo.learningportal.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
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
public class CourseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true)
	private String name;

	@ManyToOne
	@JoinColumn(name = "course_category_id")
	private CourseCategoryEntity courseCategory;

	@OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
	private Set<EnrollmentEntity> enrollments;

	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private UserEntity publisher;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<FavouritesEntity> favourites;

	@Column(name = "created_at")
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private Date updatedAt;

//	@Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
	private boolean status;

}
