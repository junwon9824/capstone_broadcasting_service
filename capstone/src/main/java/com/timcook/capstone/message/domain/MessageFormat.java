package com.timcook.capstone.message.domain;

public enum MessageFormat {
	
	MESSAGE_TYPE(0),
	DEVICE_ID(1),
	TITLE(1),
	REPLY_SORT(2),
	TEMPERATURE(2),
	HUMIDITY(3),
	VIBRATION(4),
	GASLEAK(5),
	ABNORMALNESS(6);
	
	private final int index;
	
	MessageFormat(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return this.index;
	}
}
