package com.skilldistillery.playspaces.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.playspaces.entities.User;
import com.skilldistillery.playspaces.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User register(User user) {
		String encryptedPassword = encoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		user.setEnabled(true);
		user.setRole("standard");
		userRepo.saveAndFlush(user);
		return user;
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}

}
