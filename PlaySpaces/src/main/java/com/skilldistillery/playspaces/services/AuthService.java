package com.skilldistillery.playspaces.services;

import com.skilldistillery.playspaces.entities.User;

public interface AuthService {
	public User register(User user);
	public User getUserByUsername(String username);
}
