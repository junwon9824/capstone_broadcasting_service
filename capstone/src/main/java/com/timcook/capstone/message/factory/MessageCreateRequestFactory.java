package com.timcook.capstone.message.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.timcook.capstone.message.domain.AbstractMessage;
import com.timcook.capstone.message.domain.DetectMessage;
import com.timcook.capstone.message.domain.UrgentMessage;
import com.timcook.capstone.message.dto.MessageCreateRequsetInterface;
import com.timcook.capstone.message.dto.UrgentMessageCreateRequest;
import com.timcook.capstone.message.dto.DetectMessageCreateRequest;

public class MessageCreateRequestFactory extends AbstractMessageCreateRequestFactory{

	@Override
	public MessageCreateRequsetInterface create(MessageType messageType, List<String> payload) {
		switch(messageType) {
		case DETECT: 
			return createDetectMessageCreateRequest(payload);
		case URGENT: 
			return createUrgentMessageCreateRequest(payload);
		default:
			throw new IllegalArgumentException("잘못된 데이터 형식입니다.");
		}
	}
	
	private DetectMessageCreateRequest createDetectMessageCreateRequest(List<String> payload) {
		DetectMessageCreateRequest detectMessageCreateRequest = new DetectMessageCreateRequest(payload);
		return detectMessageCreateRequest;
	}
	
	private UrgentMessageCreateRequest createUrgentMessageCreateRequest(List<String> payload) {
		UrgentMessageCreateRequest urgentMessageCreateRequest = new UrgentMessageCreateRequest();
		return urgentMessageCreateRequest;
	}

}
