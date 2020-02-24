package com.parabolt.academyHackaton.back1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Back1Application {

	public static void main(String[] args) {
		SpringApplication.run(Back1Application.class, args);
	}

}
