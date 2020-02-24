package com.parabolt.academyHackaton.back1.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.parabolt.academyHackaton.back1.request.CreateUserRequest;
import com.parabolt.academyHackaton.back1.request.LoginUserRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class User {
	
	public User(CreateUserRequest userRequest){
		this.email=userRequest.getEmail();
		this.password=userRequest.getPassword();
		this.loginDate = new Date();
		this.role=userRequest.getRole();
		this.name=userRequest.getName();
		this.stage=1; //TODO Design business logic
	}
	
	public User(LoginUserRequest userRequest){
		this.email=userRequest.getEmail();
		this.password=userRequest.getPassword();
		this.loginDate = new Date();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private Date loginDate;
	
	@Column
	private String role;
	
	@Column
	private int stage; //Crear tabla many to many
	
	
	
}
