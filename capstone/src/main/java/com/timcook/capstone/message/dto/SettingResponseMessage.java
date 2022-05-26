package com.timcook.capstone.message.dto;

import com.timcook.capstone.message.domain.MessageType;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SettingResponseMessage {

	private String username;
	private Long deviceId;
	private Long villageId;
	
	@Builder
	public SettingResponseMessage(String username, Long deviceId, Long villageId) {
		this.username = username;
		this.deviceId = deviceId;
		this.villageId = villageId;
	}
	
	public String connectFailPayload() {
		return MessageType.SETTING.name() + "/-1"; 
	}
	
	public String connectSuccessPayload(String username) {
		return MessageType.SETTING.name() + "/" + deviceId + "/" + username + "/" + villageId;
	}
}
