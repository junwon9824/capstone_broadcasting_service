package com.timcook.capstone.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timcook.capstone.dto.user.UserCreateRequest;
import com.timcook.capstone.dto.user.UserResponse;
import com.timcook.capstone.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserResponse>> findAll(){
		return ResponseEntity.ok(userService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<UserResponse> register(@Validated @RequestBody UserCreateRequest userCreateRequest){
		return ResponseEntity.ok(userService.register(userCreateRequest));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getProfile(@PathVariable Long id){
		return ResponseEntity.ok(userService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		return ResponseEntity.ok("회원이 삭제되었습니다.");
	}
}
