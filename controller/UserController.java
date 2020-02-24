package com.parabolt.academyHackaton.back1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parabolt.academyHackaton.back1.entity.User;
import com.parabolt.academyHackaton.back1.request.CreateUserRequest;
import com.parabolt.academyHackaton.back1.request.LoginUserRequest;
import com.parabolt.academyHackaton.back1.service.UserService;


@Controller
@RequestMapping("/home")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@CrossOrigin
	@PostMapping("/users")
	public ResponseEntity<?> createUser (@RequestBody CreateUserRequest newUser){
		
		Optional<User> optUser = userService.getByEmail(newUser.getEmail());
		
		if(optUser.isPresent()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		else {
			
			User user= userService.createUser(new User(newUser));
			return new ResponseEntity<User>(user,HttpStatus.CREATED);
			
		}
		
	}
	
	@CrossOrigin
	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers (){
		
		List<User> users = new ArrayList<User>();
		users = userService.getAllUsers();
		
		//HttpHeaders headers = new HttpHeaders();
	    //headers.add("Access-Control-Allow-Origin", "*");
		
		 //return new ResponseEntity<List<User>>(users,headers,HttpStatus.OK);
		 
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		
	}
	

	public Optional<User> authenticate(LoginUserRequest user) {
				
		Optional<User> optUser = userService.getByEmail(user.getEmail());
		if(optUser.isPresent()) {
			User autUser=optUser.get();
			if(user.getPassword().equals(autUser.getPassword())) {
				return optUser;
			}
			else {
				return Optional.ofNullable(null);
			}
		}
		else {
			
			return optUser;
		}	
	}
	  
	@CrossOrigin
	@PutMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginUserRequest user) {
				
		Optional<User> optUser = authenticate(user);
				
		if(optUser.isPresent()) {
			return new ResponseEntity<User>(optUser.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			
	}
	
	@CrossOrigin
	@PutMapping("/users/{stg}")
	public ResponseEntity<?> updateUserStage(@RequestBody LoginUserRequest user, @PathVariable int stg) {
		
		Optional<User> optUser = authenticate(user);
		
		if(optUser.isPresent()) {
			User result = userService.updateUser(optUser.get(), stg);
			return new ResponseEntity<User>(result,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			
	}
	
	
	
}
