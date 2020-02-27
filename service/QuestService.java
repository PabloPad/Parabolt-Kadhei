package com.parabolt.academyHackaton.back1.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parabolt.academyHackaton.back1.entity.Adventure;
import com.parabolt.academyHackaton.back1.entity.Quest;
import com.parabolt.academyHackaton.back1.repository.AdventureRepository;
import com.parabolt.academyHackaton.back1.repository.QuestRepository;
import com.parabolt.academyHackaton.back1.request.QuestRequest;

@Service
public class QuestService {
	
	@Autowired
	QuestRepository questRepository;
	
	@Autowired
	AdventureRepository adventureRepository;
	
	/*  --- old version --
	public Quest createQuest(Quest newQuest) {
		return questRepository.save(newQuest);
	}
	*/
	
	//Adventure setting (on test)
	public Quest createQuest(QuestRequest newQuest) {
		
		Quest quest = addQuestToAdventure(newQuest);
		return questRepository.save(quest);
		
	}

	
	
	public Quest addQuestToAdventure(QuestRequest newQuest) {
		
		Adventure questAdventure = new Adventure();
		
		
		Optional<Adventure> fetchAdventure = adventureRepository.findByName(newQuest.getAdventure());
		if(fetchAdventure.isPresent()) {
			questAdventure = fetchAdventure.get();
		}
		else {
			questAdventure = new Adventure(newQuest.getAdventure());
			questAdventure.setStages(0);
		}
		
		Quest quest = new Quest(newQuest);
		questAdventure.setStages(questAdventure.getStages()+1);
		quest.setStage(questAdventure.getStages());
		quest.setAdventure(questAdventure);
		return quest;
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
