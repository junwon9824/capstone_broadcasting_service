package com.timcook.capstone.admin.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timcook.capstone.admin.dto.AdminResponse;
import com.timcook.capstone.admin.service.AdminService;
import com.timcook.capstone.file.dto.FileCreateRequest;
import com.timcook.capstone.file.service.FileService;
import com.timcook.capstone.user.dto.UserResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/admins")
@RequiredArgsConstructor
@Slf4j
public class AdminController {
	
	private final AdminService adminService;
	private final FileService fileService;
	
	@GetMapping
	public ResponseEntity<List<AdminResponse>> findAll(){
		return ResponseEntity.ok(adminService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AdminResponse> findById(@PathVariable Long id){
		return ResponseEntity.ok(adminService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		adminService.delete(id);
		return ResponseEntity.ok("회원(이장)이 성공적으로 제거되었습니다.");
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<UserResponse> changeToUser(@PathVariable Long id){
		return ResponseEntity.ok(adminService.changeToUser(id));
	}

	@PostMapping("/{id}/files")
	public ResponseEntity<String> createFile(@PathVariable Long id, @RequestBody FileCreateRequest fileCreateRequest){
		fileService.create(id, fileCreateRequest);
		return ResponseEntity.ok("방송 파일이 등록되었습니다.");
	}
}
