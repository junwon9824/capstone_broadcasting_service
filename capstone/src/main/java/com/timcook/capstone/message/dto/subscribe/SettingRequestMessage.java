package com.timcook.capstone.message.dto.subscribe;

import java.util.List;

import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.device.dto.DeviceCreateRequest;
import com.timcook.capstone.message.domain.MessageFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SettingRequestMessage implements MessageCreateRequsetInterface{

	private Device device;
	private String phoneNumber;

	@Builder
	public SettingRequestMessage(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public SettingRequestMessage(List<String> payload) {
		this.phoneNumber = payload.get(MessageFormat.PHONE_NUMBER.getIndex());
	}
}
