package com.timcook.capstone.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timcook.capstone.admin.dto.AdminResponse;
import com.timcook.capstone.device.dto.DeviceResponse;
import com.timcook.capstone.notification.service.NotificationService;
import com.timcook.capstone.user.dto.UserCreateRequest;
import com.timcook.capstone.user.dto.UserResponse;
import com.timcook.capstone.user.service.UserService;
import com.timcook.capstone.village.dto.VillageResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final UserService userService;
	private final NotificationService notificationService;
	
	@GetMapping
	public ResponseEntity<List<UserResponse>> findAll(){
		log.info("findAll");
		return ResponseEntity.ok(userService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<UserResponse> register(String email){
		return ResponseEntity.ok(userService.register(email));
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<UserResponse> findById(@PathVariable String email){
		return ResponseEntity.ok(userService.findByEmail(email));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserResponse> registerData(@PathVariable Long id,
			@Validated @RequestBody UserCreateRequest userCreateRequest){
		return ResponseEntity.ok(userService.registerInformation(id, userCreateRequest));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		notificationService.deleteToken(id); // delete token 
		userService.delete(id);
		return ResponseEntity.ok("유저가 삭제되었습니다.");
	}
	
	@PutMapping("/admins/{id}")
	public ResponseEntity<AdminResponse> changeToAdmin(@PathVariable Long id){
		return ResponseEntity.ok(userService.changeToAdmin(id));
	}
	
	@GetMapping("/{id}/devices")
	public ResponseEntity<DeviceResponse> findDeviceById(@PathVariable Long id){
		return ResponseEntity.ok(userService.findDeviceById(id));
	}
	
	@GetMapping("/{id}/villages")
	public ResponseEntity<VillageResponse> findVillageById(@PathVariable Long id){
		return ResponseEntity.ok(userService.findVillageById(id));
	}
	
	@PostMapping("/{id}/villages")
	public ResponseEntity<String> registerVillage(@PathVariable Long id, Long villageId){
		userService.registerVillage(id, villageId);
		return ResponseEntity.ok("마을이 등록되었습니다.");
	}
	
	@GetMapping("/{id}/ward")
	public ResponseEntity<UserResponse> getWard(@PathVariable Long id){
		return ResponseEntity.ok(userService.getWard(id));
	}
	
	@PostMapping("/{id}/guardian")
	public ResponseEntity<String> registerWard(@PathVariable Long id, Long guardianId){
		userService.registerGaurdian(id, guardianId);
		return ResponseEntity.ok("보호자가 등록되었습니다.");
	}
}
