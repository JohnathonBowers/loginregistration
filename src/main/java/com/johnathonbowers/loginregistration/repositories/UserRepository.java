package com.johnathonbowers.loginregistration.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.johnathonbowers.loginregistration.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public Optional<User> findByEmail(String email);
	
	public Optional<User> findById(Long userId);
	
}