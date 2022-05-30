package com.timcook.capstone.user.repository;

import java.util.List;

import com.timcook.capstone.user.dto.UserResponse;

public interface CustomUserRepository {

	
	List<UserResponse> searchBy(String username);
	
}
