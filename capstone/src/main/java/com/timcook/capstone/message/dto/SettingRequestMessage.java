package com.timcook.capstone.message.dto;

import java.util.List;

import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.device.dto.DeviceCreateRequest;
import com.timcook.capstone.message.domain.MessageFormat;
import com.timcook.capstone.message.domain.MessageType;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SettingRequestMessage implements MessageCreateRequsetInterface{

	private Long deviceId;
	private String phoneNumber;

	@Builder
	public SettingRequestMessage(Long deviceId, String phoneNumber) {
		this.deviceId = deviceId;
		this.phoneNumber = phoneNumber;
	}
	
	public SettingRequestMessage(List<String> payload) {
		this.deviceId = Long.valueOf(payload.get(MessageFormat.DEVICE_ID.getIndex()));
		this.phoneNumber = payload.get(MessageFormat.PHONE_NUMBER.getIndex());
	}
	
	public String connectFailPayload() {
		return MessageType.SETTING.name() + "/-1"; 
	}
	
	public String connectSuccessPayload(String username) {
		return MessageType.SETTING.name() + "/" + deviceId + "/" + username;
	}
}
