package com.parabolt.academyHackaton.back1.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserRequest {

	private String email;
	private String password;
	private String name;
	private String role; //TODO implement validation
	
	
}
