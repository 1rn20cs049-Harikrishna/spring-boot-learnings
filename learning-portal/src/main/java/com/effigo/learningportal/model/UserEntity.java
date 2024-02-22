package com.effigo.learningportal.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "role_id")
	private RolesEntity role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<EnrollmentEntity> enrollments;

	@OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
	private Set<CourseEntity> publishedCourses;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<FavouritesEntity> favourites;

	@Column()
	private String name;

	@Column()
	private String email;

	@Column(name = "phone_number")
	private BigInteger phoneNumber;

	@Column
	private Boolean status;

	@Column()
	private String password;

	@Column(name = "created_at")
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private Date updatedAt;

	@PrePersist
	public void setStatus() {
		this.status = true;
	}

}
