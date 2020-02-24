package com.parabolt.academyHackaton.back1.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginUserRequest {
	private String email;
	private String password;
	
}
