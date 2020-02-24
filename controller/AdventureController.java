package com.parabolt.academyHackaton.back1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parabolt.academyHackaton.back1.entity.Adventure;
import com.parabolt.academyHackaton.back1.service.AdventureService;

@Controller
@RequestMapping("/home")
public class AdventureController {

	@Autowired
	private AdventureService adventureService;
	
	@PostMapping("/adventures")
	public ResponseEntity<?> createAdventure(@RequestBody Adventure adventure){
		
		adventureService.createAdventure(adventure);
		return new ResponseEntity<Adventure>(adventure,HttpStatus.OK);
	}
	


}
