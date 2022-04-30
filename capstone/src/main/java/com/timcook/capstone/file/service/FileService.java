package com.timcook.capstone.file.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timcook.capstone.admin.domain.Admin;
import com.timcook.capstone.admin.repository.AdminRepository;
import com.timcook.capstone.file.domain.File;
import com.timcook.capstone.file.dto.FileCreateRequest;
import com.timcook.capstone.file.repository.FileRepository;
import com.timcook.capstone.village.domain.Village;
import com.timcook.capstone.village.repository.VillageRepository;

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
						.title(fileCreateRequest.getTitle())
						.village(village)
						.contents(fileCreateRequest.getContents())
						.build();
		
		admin.addFile(file);
		
		fileRepository.save(file);
	}
	
}
