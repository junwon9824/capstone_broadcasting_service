package com.timcook.capstone.message.dto.subscribe;

import javax.validation.constraints.NotNull;

import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.message.domain.AbstractMessage;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReplyMessageCreateRequest implements MessageCreateRequsetInterface{

	@NotNull
	private Device device;
	@NotNull
	private String title;
	@NotNull
	private int reply_num;
	
	@Builder
	public ReplyMessageCreateRequest(Device device, String title, int reply_num) {
		this.device = device;
		this.title = title;
		this.reply_num = reply_num;
	}
	
	
	
}
