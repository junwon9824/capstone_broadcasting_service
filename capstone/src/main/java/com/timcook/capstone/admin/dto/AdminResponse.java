package com.timcook.capstone.admin.dto;

import javax.validation.constraints.NotNull;

import com.timcook.capstone.admin.domain.Admin;
import com.timcook.capstone.user.domain.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponse {
	
	@NotNull
	private Long id;
	
	private String username;
	private String email;
	private String phoneNumber;
	private String address;
	private Role role;
	
	public static AdminResponse from(Admin admin) {
		return AdminResponse.builder()
				.username(admin.getUsername())
				.email(admin.getEmail())
				.phoneNumber(admin.getPhoneNumber())
				.address(admin.getAddress())
				.role(admin.getRole())
				.build();
	}
}
