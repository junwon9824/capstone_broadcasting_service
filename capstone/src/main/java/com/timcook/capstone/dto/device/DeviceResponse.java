package com.timcook.capstone.dto.device;

import com.timcook.capstone.domain.Device;
import com.timcook.capstone.dto.user.UserResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeviceResponse {

	private Long id;
	private UserResponse userResponse;
	
	public static DeviceResponse from(Device device) {
		return new DeviceResponse(device.getId(), UserResponse.from(device.getUser()));
	}
}
