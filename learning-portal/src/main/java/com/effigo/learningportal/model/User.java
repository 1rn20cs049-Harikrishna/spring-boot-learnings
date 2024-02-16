package com.effigo.learningportal.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

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
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Roles role;

	@Column(nullable = true)
	private String name;

	@Column(nullable = true)
	private String email;

	@Column(name = "phone_number", nullable = true)
	private BigInteger phoneNumber;

	@Column(nullable = true)
	private boolean status = true;

	@Column(nullable = true)
	private String password;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;
	
	
	@OneToMany(mappedBy = "publisher")
    private Set<Course> publishedCourses;

    @OneToMany(mappedBy = "user")
    private Set<Favourites> favourites;

    @OneToMany(mappedBy = "user")
    private Set<Enrollment> enrollments;

	

}
