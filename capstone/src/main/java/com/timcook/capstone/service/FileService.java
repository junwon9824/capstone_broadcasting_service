package com.timcook.capstone.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timcook.capstone.domain.Admin;
import com.timcook.capstone.domain.File;
import com.timcook.capstone.domain.Village;
import com.timcook.capstone.dto.file.FileCreateRequest;
import com.timcook.capstone.repository.admin.AdminRepository;
import com.timcook.capstone.repository.file.FileRepository;
import com.timcook.capstone.repository.village.VillageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileService {

	private final FileRepository fileRepository;
	private final AdminRepository adminRepository;
	private final VillageRepository villageRepository;
		
	@Transactional
	public void create(Long adminId, FileCreateRequest fileCreateRequest) {
		Admin admin = adminRepository.findById(adminId)
								.orElseThrow(() -> new IllegalArgumentException("없는 이장번호 입니다."));
		
		Village village = villageRepository.findById(fileCreateRequest.getVillageId())
								.orElseThrow(() -> new IllegalArgumentException("없는 마을번호 입니다."));
		
		File file = File.builder()
						.admin(admin)
						.village(village)
						.contents(fileCreateRequest.getContents())
						.build();
		
		admin.addFile(file);
		
		fileRepository.save(file);
	}
	
	
	
}
