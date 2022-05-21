package com.timcook.capstone.message.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timcook.capstone.message.dto.MessageResponse;
import com.timcook.capstone.message.service.DetectMessageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
@Slf4j
public class MessageController {

	private final DetectMessageService detectMessageService;
	
	@GetMapping("/{id}")
	public ResponseEntity<List<MessageResponse>> getMessage(@PathVariable Long id){
		log.info("=감지 데이터 찾기=");
		log.info("=입력된 userId : {}=",id);
		return ResponseEntity.ok(detectMessageService.getMessage(id));
	}
	
}
