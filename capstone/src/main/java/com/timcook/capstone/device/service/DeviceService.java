package com.timcook.capstone.device.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.device.dto.DeviceCreateRequest;
import com.timcook.capstone.device.dto.DeviceResponse;
import com.timcook.capstone.device.dto.DeviceUpdateRequest;
import com.timcook.capstone.device.repository.DeviceRepository;
import com.timcook.capstone.user.domain.User;
import com.timcook.capstone.user.repository.UserRepository;
import com.timcook.capstone.village.domain.Village;
import com.timcook.capstone.village.repository.VillageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DeviceService {

	private final DeviceRepository deviceRepository;
	private final UserRepository userRepository;
	private final VillageRepository villageRepository;
	
	public Device findDeviceById (Long id) {
		return deviceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없는 단말기입니다."));
	}
	
	public List<DeviceResponse> findAll(){
		return deviceRepository.findAll().stream()
						.map(device -> DeviceResponse.from(device))
						.collect(Collectors.toList());
	}
	
	public DeviceResponse findById(Long id) {
		Device device = deviceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없는 단말기입니다."));
		return DeviceResponse.from(device);
	}
	
	@Transactional
	public DeviceResponse create(DeviceCreateRequest deviceCreateRequest) {
		Village village = villageRepository.findById(deviceCreateRequest.getVillageId())
								.orElseThrow(() -> new IllegalArgumentException("없는 마을입니다."));
		
		User user = userRepository.findById(deviceCreateRequest.getMemberId())
								.orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
		
		return DeviceResponse.from(DeviceCreateRequest.toEntity(user, village));
	}
	
	@Transactional
	public void delete(Long id) {
		Device device = deviceRepository.findById(id)
								.orElseThrow(() -> new IllegalArgumentException("없는 단말기입니다."));
		
		deviceRepository.delete(device);
	}
	
	@Transactional
	public DeviceResponse update(Long id ,DeviceUpdateRequest deviceUpdateRequest) {
		Device device = deviceRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("없는 단말기입니다."));
		Village village = villageRepository.findById(deviceUpdateRequest.getVillageId())
				.orElseThrow(() -> new IllegalArgumentException("없는 마을입니다."));
		User user = userRepository.findById(deviceUpdateRequest.getMemberId())
				.orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));

		device.changeInfo(user, village);
		
		return DeviceResponse.from(device);
	}
}
