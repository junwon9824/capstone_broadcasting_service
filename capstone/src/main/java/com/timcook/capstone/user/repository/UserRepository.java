package com.timcook.capstone.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.timcook.capstone.user.domain.User;
import com.timcook.capstone.user.dto.UserResponse;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);
	
	@Query("select u from User u where u.phoneNumber = :number")
	Optional<User> findByPhoneNumber(@Param("number") String phoneNumber);
	
}
