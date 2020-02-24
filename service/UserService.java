package com.parabolt.academyHackaton.back1.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parabolt.academyHackaton.back1.entity.User;
import com.parabolt.academyHackaton.back1.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User createUser(User newUser) {
		
		return userRepository.save(newUser);
	}
	
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}
	
	public Optional<User> getByEmail(String username) {
		
		return userRepository.findByEmail(username);
		
	}
	
	public User updateUser(User userToUpdate, Integer stg) {
		
		userToUpdate.setStage(stg);
		
		return userRepository.save(userToUpdate);
	}
	
	/*
	public User getUserByUsername() {
		
		List<User> users = new ArrayList<User>();
		users=getAllUsers();
		User userFound;
		
		return userFound;
	}
	*/
	
}
