package com.parabolt.academyHackaton.back1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parabolt.academyHackaton.back1.entity.Adventure;
import com.parabolt.academyHackaton.back1.service.AdventureService;

@Controller
@CrossOrigin
@RequestMapping("/home")
public class AdventureController {

	@Autowired
	private AdventureService adventureService;
	
	@GetMapping("/adventures")
	public ResponseEntity<?> getAllAdventures(){

		return new ResponseEntity<List<Adventure>>(adventureService.getAllAdventures(),HttpStatus.OK);
		
	}
	
	@PostMapping("/adventures")
	public ResponseEntity<?> createAdventure(@RequestBody Adventure adventure){
		adventureService.createAdventure(adventure);
		return new ResponseEntity<Adventure>(adventure,HttpStatus.OK);
	}
	


}
