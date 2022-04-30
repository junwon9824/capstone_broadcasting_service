package com.timcook.capstone.message.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.timcook.capstone.message.domain.AbstractMessage;
import com.timcook.capstone.message.domain.DetectMessage;
import com.timcook.capstone.message.domain.UrgentMessage;
import com.timcook.capstone.message.dto.MessageCreateRequsetInterface;
import com.timcook.capstone.message.dto.DetectMessageCreateRequest;

public class MessageFactory extends AbstractMessageFactory{

	@Override
	public AbstractMessage create(MessageType messageType, MessageCreateRequsetInterface messageCreateRequest) {
		switch(messageType) {
		case DETECT: 
			return (DetectMessage) messageCreateRequest.toEntity();
		case URGENT: 
			return (UrgentMessage) messageCreateRequest.toEntity();
		default:
			throw new IllegalArgumentException("잘못된 데이터 정보입니다.");
		}
	}
	
	
}
