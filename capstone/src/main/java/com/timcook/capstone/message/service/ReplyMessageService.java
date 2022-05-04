package com.timcook.capstone.message.service;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	private static final int CONFIRM = 1;
	private static final int ENABLE = 0;
	private final DeviceRepository deviceRepository;
	
	
	@Transactional
	public void changeStatus(ReplyMessageCreateRequest replyMessageCreateRequest) {
		log.info("-----REPLY SERVICE-----");
		log.info("DEVICE ID : {}",replyMessageCreateRequest.getDevice().getId());
		
		Device device = deviceRepository.getById(replyMessageCreateRequest.getDevice().getId());
		device.changeStatus(Status.ENABLE);
		
		if(replyMessageCreateRequest.getKindOfReply() == CONFIRM) {
			device.subtractUnconfirmCount();
		}else if(replyMessageCreateRequest.getKindOfReply() == ENABLE) {
			device.subtractDisabledCount();
		}
		
		log.info("device status : {}", device.getStatus().name());
	}
	
	
	
	
}
