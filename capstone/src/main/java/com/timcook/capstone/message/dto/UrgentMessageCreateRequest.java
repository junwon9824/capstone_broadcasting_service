package com.timcook.capstone.message.dto;

import javax.validation.constraints.NotNull;

import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.message.domain.AbstractMessage;
import com.timcook.capstone.message.domain.UrgentMessage;

public class UrgentMessageCreateRequest implements MessageCreateRequsetInterface{
		
	@NotNull
	private Device device;

	public UrgentMessage toEntity() {
		return null;
	}
	
	
}
