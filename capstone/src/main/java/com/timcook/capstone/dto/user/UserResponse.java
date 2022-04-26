package com.timcook.capstone.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.timcook.capstone.domain.Role;
import com.timcook.capstone.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	
	@NotNull
	private Long id; 
	
	@NotBlank(message = "닉네임은 비어있을 수 없습니다.")
	private String username;
	private String email;
	private Role role;
	
	public static UserResponse from(User user) {
		return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRole());
	}
}
