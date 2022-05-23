package com.timcook.capstone.message.repository.urgent;

import java.util.List;

import com.timcook.capstone.message.dto.UrgentMessageReponse;

public interface CustomUrgentMessageRepository {

	List<UrgentMessageReponse> findAllByUserId(Long userId);
	
}
