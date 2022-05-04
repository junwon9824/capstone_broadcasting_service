package com.timcook.capstone.message.dto.subscribe;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.message.domain.MessageFormat;

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
	private int reply_sort;
	
	@Builder
	public ReplyMessageCreateRequest(Device device, String title, int reply_sort) {
		this.device = device;
		this.title = title;
		this.reply_sort = reply_sort;
	}
	
	public ReplyMessageCreateRequest(List<String> payload) {
		this.title = payload.get(MessageFormat.TITLE.getIndex());
		this.reply_sort = Integer.parseInt(payload.get(MessageFormat.REPLY_SORT.getIndex()));
	}
	
}
