package com.parabolt.academyHackaton.back1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parabolt.academyHackaton.back1.entity.Adventure;

public interface AdventureRepository extends JpaRepository<Adventure, Integer> {

	public Optional<Adventure> findByName(String name);
}
