package com.timcook.capstone.file.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timcook.capstone.admin.domain.Admin;
import com.timcook.capstone.admin.repository.AdminRepository;
import com.timcook.capstone.common.config.MqttConfig.OutboundGateWay;
import com.timcook.capstone.device.domain.Status;
import com.timcook.capstone.device.repository.DeviceRepository;
import com.timcook.capstone.file.domain.File;
import com.timcook.capstone.file.dto.FileCreateRequest;
import com.timcook.capstone.file.repository.FileRepository;
import com.timcook.capstone.message.dto.publish.BroadcastMessage;
import com.timcook.capstone.message.factory.MessageType;
import com.timcook.capstone.village.domain.Village;
import com.timcook.capstone.village.repository.VillageRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileService {

	private final FileRepository fileRepository;
	private final AdminRepository adminRepository;
	private final VillageRepository villageRepository;
	private final DeviceRepository deviceRepository;
	private final OutboundGateWay outboundGateWay;
	
	@Transactional
	public void create(Long adminId, FileCreateRequest fileCreateRequest) {
		Admin admin = adminRepository.findById(adminId)
								.orElseThrow(() -> new IllegalArgumentException("없는 이장번호 입니다."));
		
		Village village = villageRepository.findById(fileCreateRequest.getVillageId())
								.orElseThrow(() -> new IllegalArgumentException("없는 마을번호 입니다."));
		
		// device add count
		village.getDevices().forEach(device -> {
					device.addDisabledCount();
					device.addUnconfirmCount();
					device.changeStatus(Status.DISABLE);});
		
		File file = File.builder()
						.admin(admin)
						.title(fileCreateRequest.getTitle())
						.village(village)
						.contents(fileCreateRequest.getContents())
						.build();
		
		admin.addFile(file);
		fileRepository.save(file);
		
		publish(file, village);
	}
	
	private void publish(File file, Village village) {
		BroadcastMessage broadcastMessage = BroadcastMessage.builder()
												.type(MessageType.MASTER)
												.title(file.getTitle())
												.contents(file.getContents())
												.build();
		
		outboundGateWay.sendToMqtt(broadcastMessage.toPayload(), "/village"+village.getId().toString());
		
		log.info("-------PUBLISH BROADCAST-------");
		log.info("[FILE] : {}", broadcastMessage.toPayload());
	}
}
