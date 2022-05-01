package com.timcook.capstone.message.domain;

public enum MessageIndex {
	
	MESSAGE_TYPE(0),
	DEVICE_ID(1),
	TEMPERATURE(2),
	HUMIDITY(3),
	VIBRATION(4),
	GASLEAK(5),
	ABNORMALNESS(6);
	
	private final int index;
	
	MessageIndex(int index) {
		this.index = index;
	}
	
	public int getIndex() {
		return this.index;
	}
}
