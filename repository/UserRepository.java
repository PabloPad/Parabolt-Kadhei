package com.parabolt.academyHackaton.back1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parabolt.academyHackaton.back1.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String username);
}
