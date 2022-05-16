package com.timcook.capstone.village.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimbusds.oauth2.sdk.Response;
import com.timcook.capstone.device.dto.DeviceResponse;
import com.timcook.capstone.file.dto.FileResponse;
import com.timcook.capstone.file.service.FileService;
import com.timcook.capstone.user.dto.UserResponse;
import com.timcook.capstone.village.dto.VillageCreateRequest;
import com.timcook.capstone.village.dto.VillageResponse;
import com.timcook.capstone.village.service.VillageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/villages")
@RequiredArgsConstructor
@Slf4j
public class VillageController {

	private final VillageService villageService;
	
	@GetMapping
	public ResponseEntity<List<VillageResponse>> findAll(){
		return ResponseEntity.ok(villageService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<VillageResponse> create(@Valid @RequestBody VillageCreateRequest villageCreateRequest){
		return ResponseEntity.ok(villageService.create(villageCreateRequest));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VillageResponse> findById(@PathVariable Long id){
		return ResponseEntity.ok(villageService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		villageService.delete(id);
		return ResponseEntity.ok("마을이 삭제되었습니다.");
	}
	
	@GetMapping("/{id}/devices")
	public ResponseEntity<List<DeviceResponse>> findAllDevices(@PathVariable Long id){
		return ResponseEntity.ok(villageService.findAllDevices(id));
	}
	@PostMapping("/{id}/admins")
	public ResponseEntity<String> setAdmin(@PathVariable Long id, Long adminId){
		villageService.setAdmin(id, adminId);
		return ResponseEntity.ok("이장이 등록되었습니다.");
	}
	
	@PutMapping("/{id}/admins")
	public ResponseEntity<String> changeAdmin(@PathVariable Long id, Long adminId){
		villageService.setAdmin(id, adminId);
		return ResponseEntity.ok("이장이 변경되었습니다.");
	}
	
	@DeleteMapping("/{id}/admins")
	public ResponseEntity<String> deleteAdmin(@PathVariable Long id){
		villageService.deleteAdmin(id);
		return ResponseEntity.ok("이장이 삭제되었습니다.");
	}
	
	@GetMapping("/{id}/files")
	public ResponseEntity<List<FileResponse>> getFiles(@PathVariable Long id){
		return ResponseEntity.ok(villageService.getFiles(id));
	}
	
	@GetMapping("/{id}/users")
	public ResponseEntity<List<UserResponse>> getUsers(@PathVariable Long id){
		return ResponseEntity.ok(villageService.getUsers(id));
	}
}

