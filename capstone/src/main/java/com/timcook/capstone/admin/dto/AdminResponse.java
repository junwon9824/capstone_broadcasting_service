package com.timcook.capstone.admin.dto;

import javax.validation.constraints.NotNull;

import com.timcook.capstone.admin.domain.Admin;
import com.timcook.capstone.user.domain.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponse {
	
	@NotNull
	private Long id;
	
	private String username;
	private String email;
	private Role role;
	
	public static AdminResponse from(Admin admin) {
		return new AdminResponse(admin.getId(), admin.getUsername(), admin.getEmail(), admin.getRole());
	}
}
