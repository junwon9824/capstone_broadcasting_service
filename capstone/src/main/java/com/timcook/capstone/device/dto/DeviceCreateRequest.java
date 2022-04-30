package com.timcook.capstone.device.dto;

import javax.validation.constraints.NotNull;

import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.user.domain.User;
import com.timcook.capstone.village.domain.Village;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceCreateRequest {

	@NotNull
	private Long memberId;
	@NotNull
	private Long villageId;
	
	public static Device toEntity(User user, Village village) {
		return new Device(village, user);
	}
	
}
