package com.bragalucas.fdtest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bragalucas.fdtest.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	Optional<User> findByEmail(String target);
}
