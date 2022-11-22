package com.skilldistillery.playspaces.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.playspaces.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
