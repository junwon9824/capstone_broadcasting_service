package com.timcook.capstone.user.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserLoginVO {
	
	@Max(value = 30)
	@NotNull(message = "EMAIL 값을 입력해주세요")
	@Email
	private String email;
	
	@NotNull(message = "PASSWORD 값을 입력해주세요")
	private String password;
	
}
