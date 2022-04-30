package com.timcook.capstone.common;

import static com.timcook.capstone.message.factory.MessageType.DETECT;
import static com.timcook.capstone.message.factory.MessageType.URGENT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.timcook.capstone.device.dto.DeviceResponse;
import com.timcook.capstone.device.repository.DeviceRepository;
import com.timcook.capstone.device.service.DeviceService;
import com.timcook.capstone.message.dto.DetectMessageCreateRequest;
import com.timcook.capstone.message.dto.MessageCreateRequsetInterface;
import com.timcook.capstone.message.factory.MessageFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class MqttUtils {

	private static final String EMERGENCY = "emergency";
	private final DeviceService deviceService;
	private final MessageFactory messageFactory = new MessageFactory();

	public void payloadToMessage(String payload) {
		log.info("=============MQTT UTILS=============");
		log.info("PAYLOAD : {}", payload);
		
		if(isUrgent(payload)) {
			log.info("MESSAGE : {}", messageFactory.create(URGENT, createDetectMessageCreateRequest(payload)));
		}
		else {
			log.info("MESSAGE : {}", messageFactory.create(DETECT, createDetectMessageCreateRequest(payload)));
		}
	}
	
	private boolean isUrgent(String payload){
		if(parsePayload(payload).get(0) == EMERGENCY) {
			return true;
		}
		return false;
	}
	
	private DetectMessageCreateRequest createDetectMessageCreateRequest(String payloadStr) {
		List<String> payload = parsePayload(payloadStr);
		DetectMessageCreateRequest detectMessageCreateRequest = new DetectMessageCreateRequest(payload);
		detectMessageCreateRequest.setDevice(deviceService.findDeviceById(Long.valueOf(payload.get(0))));
		return detectMessageCreateRequest;
	}
	
	private List<String> parsePayload(String payload){
		return new ArrayList<>(Arrays.asList(payload.split("/")));
	}
}
