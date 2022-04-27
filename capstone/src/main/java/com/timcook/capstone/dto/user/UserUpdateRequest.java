package com.timcook.capstone.dto.user;

import com.timcook.capstone.domain.Device;
import com.timcook.capstone.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserUpdateRequest {

	private String username;
	private String email;
	private Device device;
	
	public static UserUpdateRequest from(User user) {
		return new UserUpdateRequest(user.getUsername(), user.getEmail(), user.getDevice());
	}
}
