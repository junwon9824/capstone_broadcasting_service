package com.timcook.capstone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.timcook.capstone.domain.Device;
import com.timcook.capstone.domain.Village;
import com.timcook.capstone.dto.village.VillageResponse;
import com.timcook.capstone.repository.village.VillageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VillageService {

	private final VillageRepository villageRepository;
	
	
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
	
	public List<Device> findAllDevices(Long id){
		Village village = villageRepository.findById(id)
							.orElseThrow(() -> new IllegalArgumentException("해당 마을이 없습니다."));
		return village.getDevices();
	}
	
}
