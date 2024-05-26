package com.timcook.capstone.device.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeviceRegisterUserRequest {

	@NotNull
	private Long userId;

	@Builder
	public DeviceRegisterUserRequest(Long userId) {
		this.userId = userId;
	}
}
