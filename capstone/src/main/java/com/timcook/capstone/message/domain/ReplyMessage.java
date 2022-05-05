package com.timcook.capstone.message.domain;

import com.timcook.capstone.device.domain.Device;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ReplyMessage extends AbstractMessage{

	private String title;
	private Device device;
	private int reply_sort;
	
	@Builder
	public ReplyMessage(String title, Device device, int reply_sort) {
		this.title = title;
		this.device = device;
		this.reply_sort = reply_sort;
	}
	
	
}
