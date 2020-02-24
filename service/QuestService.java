package com.parabolt.academyHackaton.back1.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parabolt.academyHackaton.back1.entity.Quest;
import com.parabolt.academyHackaton.back1.repository.QuestRepository;

@Service
public class QuestService {
	
	@Autowired
	QuestRepository questRepository;
	
	public Quest createQuest(Quest newQuest) {
		
		return questRepository.save(newQuest);
				
	}
	
	public List<Quest> getAllQuests() {
		
		return questRepository.findAll();
	}
	
	public Optional<Quest> getById(Integer id) {
		
		return questRepository.findById(id);
		
	}
	
	public Quest updateQuest(Quest questToUpdate, Quest update) {
		
		
		return update;
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
