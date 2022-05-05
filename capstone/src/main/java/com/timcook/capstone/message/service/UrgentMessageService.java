package com.timcook.capstone.message.service;

import com.timcook.capstone.message.domain.AbstractMessage;
import com.timcook.capstone.message.domain.UrgentMessage;
import com.timcook.capstone.message.dto.subscribe.MessageCreateRequsetInterface;
import com.timcook.capstone.message.dto.subscribe.UrgentMessageCreateRequest;
import com.timcook.capstone.message.repository.UrgentMessageRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrgentMessageService {

	private final UrgentMessageRepository urgentMessageRepository;
	
	@Transactional
	public UrgentMessage create(UrgentMessageCreateRequest createRequest) {
		return urgentMessageRepository.save(createRequest.toEntity());
	}

	
}
