package com.parabolt.academyHackaton.back1.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parabolt.academyHackaton.back1.entity.Quest;

public interface QuestRepository extends JpaRepository<Quest, Integer> {

	Optional<Quest> findByTitle(String title);
}
