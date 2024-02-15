package com.effigo.learningportal.service;

import com.effigo.learningportal.model.User;

public interface AdminService {
	public User createUser(User user);

	public String adminHome();

}
