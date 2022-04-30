package com.timcook.capstone.common;

import static com.timcook.capstone.message.factory.MessageType.DETECT;
import static com.timcook.capstone.message.factory.MessageType.URGENT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.timcook.capstone.device.service.DeviceService;
import com.timcook.capstone.message.dto.DetectMessageCreateRequest;
import com.timcook.capstone.message.dto.UrgentMessageCreateRequest;
import com.timcook.capstone.message.factory.AbstractMessageCreateRequestFactory;
import com.timcook.capstone.message.factory.MessageCreateRequestFactory;
import com.timcook.capstone.message.service.DetectMessageService;
import com.timcook.capstone.message.service.UrgentMessageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class MqttUtils {
	
	private final MessageCreateRequestFactory messageCreateRequestFactory = new MessageCreateRequestFactory();
	private static final String URGENT_MSG = "emergency";
	private static final String DETECT_MSG = "detect";
	private static final String SPLIT_REGEX = "/";
	private static final int DEVICE_ID_INDEX = 1;
	private final DeviceService deviceService;
	private final DetectMessageService detectMessageService;
	private final UrgentMessageService urgentMessageService;

	public void payloadToMessage(String payload) {
		log.info("=============MQTT UTILS=============");
		log.info("PAYLOAD : {}", payload);
		
		if(isUrgent(payload)) {
			UrgentMessageCreateRequest createRequest
						= (UrgentMessageCreateRequest) messageCreateRequestFactory.create(URGENT, parsePayload(payload));
			
			createRequest.setDevice(deviceService.findDeviceById(getDeviceId(payload)));
			log.info("URGENT : {}", urgentMessageService.create(createRequest));
			
		}
		else {
			DetectMessageCreateRequest createRequest 
						= (DetectMessageCreateRequest) messageCreateRequestFactory.create(DETECT, parsePayload(payload));
			
			createRequest.setDevice(deviceService.findDeviceById(getDeviceId(payload)));
			log.info("DETECT : {}", detectMessageService.create(createRequest).toString());
		}
	}
	
	private boolean isUrgent(String payload){
		if(parsePayload(payload).get(0) == URGENT_MSG) {
			return true;
		}
		return false;
	}

	private Long getDeviceId(String payload) {
		return Long.valueOf(parsePayload(payload).get(DEVICE_ID_INDEX));
	}
	
	private List<String> parsePayload(String payload){
		return new ArrayList<>(Arrays.asList(payload.split(SPLIT_REGEX)));
	}
	
}
