package com.timcook.capstone.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timcook.capstone.domain.Device;
import com.timcook.capstone.dto.village.VillageResponse;
import com.timcook.capstone.repository.village.VillageRepository;
import com.timcook.capstone.service.VillageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/villages")
@RequiredArgsConstructor
@Slf4j
public class VillageController {

	private final VillageService villageService;
	
	@GetMapping
	public ResponseEntity<List<VillageResponse>> findAll(){
		return ResponseEntity.ok(villageService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VillageResponse> findById(@PathVariable Long id){
		return ResponseEntity.ok(villageService.findById(id));
	}
	
	@GetMapping("/{id}/devices")
	public ResponseEntity<List<Device>> findAllDevices(@PathVariable Long id){
		return ResponseEntity.ok(villageService.findAllDevices(id));
	}
}
