package com.timcook.capstone.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timcook.capstone.dto.device.DeviceResponse;
import com.timcook.capstone.dto.village.VillageResponse;
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
	public ResponseEntity<List<DeviceResponse>> findAllDevices(@PathVariable Long id){
		return ResponseEntity.ok(villageService.findAllDevices(id));
	}
	
	@PostMapping("/{id}/admins")
	public ResponseEntity<String> setAdmin(@PathVariable Long id, Long adminId){
		villageService.setAdmin(id, adminId);
		return ResponseEntity.ok("마을 이장이 등록되었습니다.");
	}
	
	@PutMapping("/{id}/admins")
	public ResponseEntity<String> changeAdmin(@PathVariable Long id, Long adminId){
		villageService.setAdmin(id, adminId);
		return ResponseEntity.ok("마을 이장이 변경되었습니다.");
	}
	
	@DeleteMapping("/{id}/admins")
	public ResponseEntity<String> deleteAdmin(@PathVariable Long id){
		villageService.deleteAdmin(id);
		return ResponseEntity.ok("마을 이장이 삭제되었습니다.");
	}
}
