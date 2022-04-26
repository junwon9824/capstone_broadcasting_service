package com.timcook.capstone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.timcook.capstone.domain.Device;
import com.timcook.capstone.domain.User;
import com.timcook.capstone.domain.Village;
import com.timcook.capstone.dto.device.DeviceCreateRequest;
import com.timcook.capstone.repository.device.DeviceRepository;
import com.timcook.capstone.repository.user.UserRepository;
import com.timcook.capstone.repository.village.VillageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeviceService {

	private final DeviceRepository deviceRepository;
	private final UserRepository userRepository;
	private final VillageRepository villageRepository;
	
	public List<Device> findAll(){
		return deviceRepository.findAll();
	}
	
	public Device create(DeviceCreateRequest deviceCreateRequest) {
		Village village = villageRepository.findById(deviceCreateRequest.getVillageId())
								.orElseThrow(() -> new IllegalArgumentException("���� �����Դϴ�."));
		
		User user = userRepository.findById(deviceCreateRequest.getMemberId())
								.orElseThrow(() -> new IllegalArgumentException("���� ȸ���Դϴ�."));
		
		return DeviceCreateRequest.toEntity(user, village);
	}
	
}