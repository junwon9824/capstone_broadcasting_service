package com.timcook.capstone.user.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.timcook.capstone.user.domain.Role;
import com.timcook.capstone.user.domain.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class UserCreateRequest {
	
	@NotNull
	@Size(max = 10, message = "�̸��� 10�� ���Ͽ��� �մϴ�.")
	private String username;
	
	@NotNull
	@Size(max = 30, message = "�̸����� 30�� ���Ͽ��� �մϴ�.")
	private String email;

	public User toEntity() {
		return User.builder()
				.email(this.email)
				.username(this.username)
				.role(Role.ROLE_USER)
				.build();
	}
}