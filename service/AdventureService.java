package com.parabolt.academyHackaton.back1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parabolt.academyHackaton.back1.entity.Adventure;
import com.parabolt.academyHackaton.back1.repository.AdventureRepository;

@Service
public class AdventureService {

	@Autowired
	AdventureRepository adventureRepository;
	
	public Adventure createAdventure (Adventure adventure) {
		
		return adventureRepository.save(adventure);
		
	}
	
}
