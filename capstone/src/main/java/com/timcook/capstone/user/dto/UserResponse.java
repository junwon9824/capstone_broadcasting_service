package com.timcook.capstone.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.querydsl.core.annotations.QueryProjection;
import com.timcook.capstone.user.domain.Role;
import com.timcook.capstone.user.domain.User;
import com.timcook.capstone.village.domain.Address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponse {
	
	private Long id; 
	private String username;
	private String email;
	private Role role;
	private String phoneNumber;
	private Address address;
	
	@Builder
	@QueryProjection
	public UserResponse (Long id, String username, String email, Role role, String phoneNumber, Address address) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public static UserResponse from(User user) {
		return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRole(), user.getPhoneNumber(), user.getAddress());
	}

	
}
