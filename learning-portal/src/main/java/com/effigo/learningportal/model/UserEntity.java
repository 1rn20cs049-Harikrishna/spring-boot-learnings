package com.effigo.learningportal.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "role_id")
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
	@ManyToOne
	private RolesEntity role;

	@OneToMany(mappedBy = "user")
	private Set<EnrollmentEntity> enrollments;

	@OneToMany(mappedBy = "publisher")
	private Set<CourseEntity> publishedCourses;

	@OneToMany(mappedBy = "user")
	private List<FavouritesEntity> favourites;

	@Column()
	private String name;

	@Column()
	private String email;

	@Column(name = "phone_number")
	private BigInteger phoneNumber;

	@Column()
	private boolean status = true;

	@Column()
	private String password;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

}
