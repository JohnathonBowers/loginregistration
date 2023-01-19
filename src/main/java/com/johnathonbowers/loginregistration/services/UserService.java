package com.johnathonbowers.loginregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.johnathonbowers.loginregistration.models.LoginUser;
import com.johnathonbowers.loginregistration.models.User;
import com.johnathonbowers.loginregistration.repositories.UserRepository;

//I referred to Jason Brady's example code from our course lectures to help me build this service.

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User create(User newUser) {
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepository.save(newUser);
	}
	
	public User register(User newUser, BindingResult result) {
		Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "Exist", "This email address is already associated with an account. Please either log in or use a different address.");
		}
		// we use .equals instead of == because we are comparing objects
		if (!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Match", "Passwords do not match!");
		}
		if (!result.hasErrors()) {
			return this.create(newUser);
		}
		return null;
	}	
		
	public User login(LoginUser newLoginUser, BindingResult result) {
		Optional<User> user = userRepository.findByEmail(newLoginUser.getEmail());
		if (!user.isPresent() || !BCrypt.checkpw(newLoginUser.getPassword(), user.get().getPassword())) {
			result.rejectValue("password", "Exist", "Email or password is incorrect!");
			return null;
		} else {
			return user.get();
		}
	}

	public User findOneById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			return null;
		}	
		return user.get();
	}
		
}
