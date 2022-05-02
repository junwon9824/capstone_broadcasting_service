package com.timcook.capstone.village.repository;

import java.util.List;

import com.timcook.capstone.device.dto.DeviceResponse;

public interface CustomVillageRepository {
		
	List<DeviceResponse> findAllDevices(Long id);
	
	
}
