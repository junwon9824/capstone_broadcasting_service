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
	@Size(max = 10, message = "이름은 10자를 넘길 수 없습니다.")
	private String username;
	@NotNull
	@Size(max = 11, message = "핸드폰 번호는 11자를 넘길 수 없습니다.")
	private String phoneNumber;	
	
	@NotNull
	@Size(max = 30)
	private String city;
	@NotNull
	@Size(max = 30)
	private String town;
	@NotNull
	@Size(max = 30)
	private String state;
}
