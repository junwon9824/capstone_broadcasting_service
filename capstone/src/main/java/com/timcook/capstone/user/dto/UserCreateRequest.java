package com.timcook.capstone.user.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.timcook.capstone.user.domain.Role;
import com.timcook.capstone.user.domain.User;
import com.timcook.capstone.village.domain.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class UserCreateRequest {
	
	@NotNull
	@Size(max = 10, message = "이름은 10자 이하여야 합니다.")
	private String username;
	@NotNull
	@Size(max = 30, message = "이메일은 30자 이하여야 합니다.")
	private String email;
	@NotNull
	@Size(max = 11, message = "핸드폰 번호 형식이 맞지 않습니다.")
	private String phoneNumber;	
	private String password;
	
	public User toEntity() {
		return User.builder()
				.email(this.email)
				.username(this.username)
				.password(password)
				.phoneNumber(this.phoneNumber)
				.role(Role.ROLE_USER)
				.build();
	}
}
