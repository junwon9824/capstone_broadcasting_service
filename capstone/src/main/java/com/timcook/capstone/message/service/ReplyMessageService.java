package com.timcook.capstone.message.service;

import javax.persistence.EntityManager;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timcook.capstone.common.mqtt.MqttBuffer;
import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.device.domain.Status;
import com.timcook.capstone.device.repository.DeviceRepository;
import com.timcook.capstone.device.service.DeviceService;
import com.timcook.capstone.message.domain.MessageFormat;
import com.timcook.capstone.message.domain.ReplyMessage;
import com.timcook.capstone.message.dto.subscribe.ReplyMessageCreateRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReplyMessageService {

	private static final int RECEPTION = 0;
	private static final int CONFIRM = 1;
	private final DeviceRepository deviceRepository;
	
	@Transactional
	public void changeStatus(ReplyMessageCreateRequest replyMessageCreateRequest) {
		log.info("-----REPLY SERVICE-----");
		log.info("DEVICE ID : {}",replyMessageCreateRequest.getDevice().getId());
		
		Device device = deviceRepository.getById(replyMessageCreateRequest.getDevice().getId());
		
		Long fileId = Long.valueOf(replyMessageCreateRequest.getFileId());
		Long deviceId = device.getId();

		log.info("===GET KIND OF REPLY, {}===", replyMessageCreateRequest.getKindOfReply());
		
		if(replyMessageCreateRequest.getKindOfReply() == CONFIRM) {
			log.info("==BUFFER REMOVE==");
			MqttBuffer.CONFIRM_BUFFER.remove(Pair.of(deviceId, fileId));
		}else if(replyMessageCreateRequest.getKindOfReply() == RECEPTION) {
			log.info("==BUFFER REMOVE==");
			MqttBuffer.REVICE_BUFFER.remove(Pair.of(deviceId, fileId));
		}
		
		log.info("device status : {}", device.getStatus().name());
	}
	
}
