package com.timcook.capstone.common.mqtt;

import static com.timcook.capstone.message.domain.MessageType.DETECT;
import static com.timcook.capstone.message.domain.MessageType.URGENT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.device.domain.Status;
import com.timcook.capstone.device.service.DeviceService;
import com.timcook.capstone.message.domain.DetectMessage;
import com.timcook.capstone.message.domain.MessageFormat;
import com.timcook.capstone.message.domain.MessageType;
import com.timcook.capstone.message.domain.ReplyMessage;
import com.timcook.capstone.message.domain.UrgentMessage;
import com.timcook.capstone.message.dto.subscribe.DetectMessageCreateRequest;
import com.timcook.capstone.message.dto.subscribe.MessageCreateRequsetInterface;
import com.timcook.capstone.message.dto.subscribe.ReplyMessageCreateRequest;
import com.timcook.capstone.message.dto.subscribe.SettingRequestMessage;
import com.timcook.capstone.message.dto.subscribe.UrgentMessageCreateRequest;
import com.timcook.capstone.message.factory.AbstractMessageCreateRequestFactory;
import com.timcook.capstone.message.factory.MessageCreateRequestFactory;
import com.timcook.capstone.message.service.DetectMessageService;
import com.timcook.capstone.message.service.ReplyMessageService;
import com.timcook.capstone.message.service.UrgentMessageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class MqttUtils {
	
	private final MessageCreateRequestFactory messageCreateRequestFactory = new MessageCreateRequestFactory();
	private static final String SPLIT_REGEX = "/";
	private final DeviceService deviceService;
	private final ReplyMessageService replyMessageService;
	private final DetectMessageService detectMessageService;
	private final UrgentMessageService urgentMessageService;
	
	public void payloadToMessage(String payload) {
		log.info("=============MQTT UTILS=============");
		log.info("PAYLOAD : {}", payload);
		
		MessageCreateRequsetInterface createRequest 
				= messageCreateRequestFactory.create(getMessageType(payload), parsePayload(payload));
		
		if(getMessageType(payload).equals(MessageType.URGENT)) {
			
			UrgentMessageCreateRequest urgentMessageCreateRequest = (UrgentMessageCreateRequest)createRequest;
			urgentMessageCreateRequest.setDevice(deviceService.findDeviceById(getDeviceId(payload)));
			UrgentMessage urgentMessage = urgentMessageService.create(urgentMessageCreateRequest);
			
		} else if(getMessageType(payload).equals(MessageType.DETECT)){
			
			DetectMessageCreateRequest detectMessageCreateRequest = (DetectMessageCreateRequest) createRequest;
			detectMessageCreateRequest.setDevice(deviceService.findDeviceById(getDeviceId(payload)));
			DetectMessage detectMessage = detectMessageService.create(detectMessageCreateRequest );
			
		} else if(getMessageType(payload).equals(MessageType.REPLY)){
			
			ReplyMessageCreateRequest replyMessageCreateRequest = (ReplyMessageCreateRequest) createRequest;
			replyMessageCreateRequest.setDevice(deviceService.findDeviceById(getDeviceId(payload)));
			replyMessageService.changeStatus(replyMessageCreateRequest);
			
		} else if(getMessageType(payload).equals(MessageType.SETTING)){
				
			SettingRequestMessage settingRequestMessage = (SettingRequestMessage) createRequest;
			settingRequestMessage.setDevice(deviceService.findDeviceById(getDeviceId(payload)));
			
			
		}
	}
	
	private MessageType getMessageType(String payload) {
		log.info("PAYLOAD_MESSAGE_TYPE : {}",parsePayload(payload).get(MessageFormat.MESSAGE_TYPE.getIndex()));
		
		String messageType = parsePayload(payload).get(MessageFormat.MESSAGE_TYPE.getIndex()); 
		
		if(messageType.equals(MessageType.URGENT.name())) {
			return MessageType.URGENT;
		}else if(messageType.equals(MessageType.DETECT.name())){
			return MessageType.DETECT;
		}else {
			return MessageType.REPLY;
		}
	}

	private Long getDeviceId(String payload) {
		return Long.valueOf(parsePayload(payload).get(MessageFormat.DEVICE_ID.getIndex()));
	}
	
	private List<String> parsePayload(String payload){
		return new ArrayList<>(Arrays.asList(payload.split(SPLIT_REGEX)));
	}
	
}
