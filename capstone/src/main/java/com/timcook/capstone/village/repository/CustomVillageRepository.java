package com.timcook.capstone.village.repository;

import java.util.List;

import com.timcook.capstone.device.dto.DeviceResponse;
import com.timcook.capstone.file.dto.FileResponse;
import com.timcook.capstone.user.dto.UserResponse;

public interface CustomVillageRepository {
		
	List<DeviceResponse> findAllDevices(Long id);
	List<FileResponse> findAllFiles(Long id);
	List<UserResponse> findAllUsers(Long id);
	
}
