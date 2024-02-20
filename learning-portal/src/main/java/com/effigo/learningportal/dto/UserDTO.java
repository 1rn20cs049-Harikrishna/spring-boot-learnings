package com.effigo.learningportal.dto;

import java.math.BigInteger;
import java.util.Date;

import com.effigo.learningportal.model.RolesEntity;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;

	private RolesEntity role;

	private  String name;

	private String email;

	private BigInteger phoneNumber;

	private boolean status;
//
//	private Date createdAt;
//
//	private Date updatedAt;
}
