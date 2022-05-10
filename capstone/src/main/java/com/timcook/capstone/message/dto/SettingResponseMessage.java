package com.timcook.capstone.message.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SettingResponseMessage {

	private String username;
	private Long deviceId;
	
	@Builder
	public SettingResponseMessage(String username, Long deviceId) {
		this.username = username;
		this.deviceId = deviceId;
	}
}
