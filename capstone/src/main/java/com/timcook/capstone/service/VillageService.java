package com.timcook.capstone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timcook.capstone.domain.Admin;
import com.timcook.capstone.domain.Village;
import com.timcook.capstone.dto.device.DeviceResponse;
import com.timcook.capstone.dto.village.VillageResponse;
import com.timcook.capstone.repository.admin.AdminRepository;
import com.timcook.capstone.repository.village.VillageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class VillageService {

	private final VillageRepository villageRepository;
	private final AdminRepository adminRepository;
	
	public List<VillageResponse> findAll(){
		return villageRepository.findAll().stream()
						.map(village -> VillageResponse.from(village))
						.collect(Collectors.toList());
	}
	
	public VillageResponse findById(Long id) {
		Village village = villageRepository.findById(id)
							.orElseThrow(() -> new IllegalArgumentException("해당 마을이 없습니다."));
		return VillageResponse.from(village); 
	}
	
	public List<DeviceResponse> findAllDevices(Long id){
		Village village = villageRepository.findById(id)
							.orElseThrow(() -> new IllegalArgumentException("해당 마을이 없습니다."));
		return village.getDevices().stream()
				.map(device -> DeviceResponse.from(device))
				.collect(Collectors.toList());
	}
	
	@Transactional
	public void setAdmin(Long villageId, Long adminId) {
		Village village = villageRepository.findById(villageId)
				.orElseThrow(() -> new IllegalArgumentException("해당 마을이 없습니다."));
		
		Admin admin = adminRepository.findById(adminId)
				.orElseThrow(() -> new IllegalArgumentException("해당 마을이 없습니다."));
		
		admin.registerVillage(village);
	}
	
	@Transactional
	public void changeAdmin(Long villageId, Long adminId) {
		Village village = villageRepository.findById(villageId)
				.orElseThrow(() -> new IllegalArgumentException("해당 마을이 없습니다."));
		
		Admin admin = adminRepository.findById(adminId)
				.orElseThrow(() -> new IllegalArgumentException("해당 마을이 없습니다."));
		
		admin.registerVillage(village);
	}
	
	@Transactional
	public void deleteAdmin(Long id) {
		Village village = villageRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 마을이 없습니다."));

		village.updateAdmin(null);
	}
}
