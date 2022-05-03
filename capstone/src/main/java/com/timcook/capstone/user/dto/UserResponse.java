package com.timcook.capstone.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.querydsl.core.annotations.QueryProjection;
import com.timcook.capstone.user.domain.Role;
import com.timcook.capstone.user.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserResponse {
	
	@NotNull
	private Long id; 
	
	@NotBlank(message = "닉네임은 비어있을 수 없습니다.")
	private String username;
	private String email;
	private Role role;
	
	@QueryProjection
	public UserResponse (Long id, String username, String email, Role role) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.role = role;
	}
	
	public static UserResponse from(User user) {
		return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRole());
	}

	
}
