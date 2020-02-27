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
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.parabolt.academyHackaton.back1.entity.Quest;
import com.parabolt.academyHackaton.back1.request.QuestRequest;
import com.parabolt.academyHackaton.back1.service.QuestService;


@Controller
@RequestMapping("/home")
public class QuestController {
	
	@Autowired
	private QuestService questService;
	
	@CrossOrigin
	@PostMapping("/quests")
	public ResponseEntity<?> createQuest (@RequestBody QuestRequest newQuest){
		
		//Quest quest = questService.createQuest(new Quest(newQuest));
		
		Quest quest = questService.createQuest(newQuest);
		
		return new ResponseEntity<Quest>(quest,HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/quests")
	public ResponseEntity<?> getAllQuests (){
		
		List<Quest> quests = new ArrayList<Quest>();
		quests = questService.getAllQuests();
		return new ResponseEntity<List<Quest>>(quests,HttpStatus.OK);
		
	}
	@CrossOrigin
	@GetMapping("/quests/{id}")
	public ResponseEntity<?> getQuestById(@PathVariable Integer id){
		
		Optional<Quest> optQuest = questService.getById(id);
		if(optQuest.isPresent()) {
			return new ResponseEntity<Quest>(optQuest.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
	
	/*
	@PutMapping("/users/{stg}")
	public ResponseEntity<?> updateUserStage(@RequestBody UserRequest user, @PathVariable int stg) {
		
		Optional<User> optUser = userService.getByUsername(user.getUsername());
		if(optUser.isPresent()) {
			User result = userService.updateUser(optUser.get(), stg);
			return new ResponseEntity<User>(result,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	*/
	
	
	
}
