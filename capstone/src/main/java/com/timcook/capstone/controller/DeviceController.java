package com.timcook.capstone.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.timcook.capstone.domain.Device;
import com.timcook.capstone.dto.device.DeviceCreateRequest;
import com.timcook.capstone.dto.device.DeviceUpdateRequest;
import com.timcook.capstone.service.DeviceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
@Slf4j
public class DeviceController {

	private final DeviceService deviceService;
	
	@GetMapping
	public ResponseEntity<List<Device>> findAll(){
		return ResponseEntity.ok(deviceService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Device> create(@Validated @RequestBody DeviceCreateRequest deviceCreateRequest) {
		return ResponseEntity.ok(deviceService.create(deviceCreateRequest));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		deviceService.delete(id);
		return ResponseEntity.ok("단말기 정보가 삭제되었습니다.");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Device> update(@Validated @RequestBody DeviceUpdateRequest deviceUpdateRequest
			,@PathVariable Long id) {
		return ResponseEntity.ok(deviceService.update(id, deviceUpdateRequest));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Device> findById(@PathVariable Long id) {
		return ResponseEntity.ok(deviceService.findById(id));
	}
}
