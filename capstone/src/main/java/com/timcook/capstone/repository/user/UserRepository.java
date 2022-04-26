package com.timcook.capstone.repository.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timcook.capstone.domain.User;
import com.timcook.capstone.dto.user.UserResponse;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);
}
