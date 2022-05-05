package com.timcook.capstone.message.dto.subscribe;

import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.message.domain.AbstractMessage;

public interface MessageCreateRequsetInterface {
	
	public void setDevice(Device device);
	
}
