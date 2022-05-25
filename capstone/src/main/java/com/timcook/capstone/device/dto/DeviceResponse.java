package com.timcook.capstone.device.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.user.dto.UserResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class DeviceResponse {

	private Long id;
	private UserResponse userResponse;
	private int unconfirmCount;
	private int disabledCount;
	
	@QueryProjection
	public DeviceResponse(Long id, UserResponse userResponse, int unconfirmCount, int disabledCount) {
		this.id = id;
		this.userResponse = userResponse;
		this.unconfirmCount = unconfirmCount;
		this.disabledCount = disabledCount;
	}
	
	public static DeviceResponse from(Device device) {
		return new DeviceResponse(device.getId(), UserResponse.from(device.getUser()),
				device.getUnconfirmInfos().size(), device.getDisabledInfos().size());
	}

	
}
