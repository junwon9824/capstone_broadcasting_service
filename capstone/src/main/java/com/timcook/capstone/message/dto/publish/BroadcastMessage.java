package com.timcook.capstone.message.dto.publish;

import com.timcook.capstone.message.factory.MessageType;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BroadcastMessage {
	
	private MessageType type;
	private String title;
	private String contents;
	
	@Builder
	public BroadcastMessage(MessageType type, String title, String contents) {
		this.type = type;
		this.title = title;
		this.contents = contents;
	}
	
	public String toPayload() {
		return  type.name() + "/" + title + "/" + contents;
	}
}
