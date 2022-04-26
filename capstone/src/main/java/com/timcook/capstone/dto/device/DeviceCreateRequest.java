package com.timcook.capstone.dto.device;

import javax.validation.constraints.NotNull;

import com.timcook.capstone.domain.Device;
import com.timcook.capstone.domain.User;
import com.timcook.capstone.domain.Village;

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
