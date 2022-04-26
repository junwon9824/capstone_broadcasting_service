package com.timcook.capstone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timcook.capstone.domain.User;
import com.timcook.capstone.dto.user.UserCreateRequest;
import com.timcook.capstone.dto.user.UserResponse;
import com.timcook.capstone.repository.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	public List<UserResponse> findAll(){
		return userRepository.findAll().stream()
				.map(user -> UserResponse.from(user))
				.collect(Collectors.toList());
	}
	
	@Transactional
	public UserResponse register(UserCreateRequest userCreateRequest) {
		User user = userRepository.save(userCreateRequest.toEntity());
		return UserResponse.from(user);
	}
	
	public UserResponse findById(Long id) {
		User user = userRepository.findById(id)
								.orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
		return UserResponse.from(user);
	}
	@Transactional
	public void delete(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
		userRepository.delete(user);
	}
}
