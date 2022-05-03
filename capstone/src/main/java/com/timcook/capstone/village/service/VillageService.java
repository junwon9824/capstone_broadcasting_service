package com.timcook.capstone.village.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.log.Log;
import com.timcook.capstone.admin.domain.Admin;
import com.timcook.capstone.admin.repository.AdminRepository;
import com.timcook.capstone.device.dto.DeviceResponse;
import com.timcook.capstone.file.dto.FileResponse;
import com.timcook.capstone.user.dto.UserResponse;
import com.timcook.capstone.village.domain.Village;
import com.timcook.capstone.village.dto.VillageResponse;
import com.timcook.capstone.village.repository.VillageRepository;
import com.timcook.capstone.village.repository.VillageRepositoryImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class VillageService {

	private final VillageRepository villageRepository;
	private final VillageRepositoryImpl villageRepositoryImpl;
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

	// N+1 문제 해결 예정 메서드 -> 해결
	public List<DeviceResponse> findAllDevices(Long id){
//		Village village = villageRepository.findById(id)
//							.orElseThrow(() -> new IllegalArgumentException("해당 마을이 없습니다."));
//		return village.getDevices().stream()
//				.map(device -> DeviceResponse.from(device))
//				.collect(Collectors.toList());
		
		
		return villageRepositoryImpl.findAllDevices(id);
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
	
	// N+1 문제 해결 예정 메서드	
	public List<FileResponse> getFiles(Long id){
		Village village = villageRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 마을이 없습니다."));
		
		return village.getFiles().stream()
						.map(file -> FileResponse.from(file))
						.collect(Collectors.toList());
	}
	
	// N+1 문제 해결 예정 메서드
	public List<UserResponse> getUsers(Long id){
		Village village = villageRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 마을이 없습니다."));
		
		log.info("---[VILLAGE] GET USERS ---");
		village.getUsers().forEach(user -> log.info("{}", user.getId()));
		
		return village.getUsers().stream()
						.map(user -> UserResponse.from(user))
						.collect(Collectors.toList());
	}
}
