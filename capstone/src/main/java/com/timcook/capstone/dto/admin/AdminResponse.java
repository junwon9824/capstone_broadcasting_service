package com.timcook.capstone.dto.admin;

import javax.validation.constraints.NotNull;

import com.timcook.capstone.domain.Admin;
import com.timcook.capstone.domain.Role;

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
