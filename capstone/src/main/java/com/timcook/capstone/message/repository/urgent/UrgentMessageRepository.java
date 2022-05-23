package com.timcook.capstone.message.repository.urgent;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timcook.capstone.message.domain.UrgentMessage;

public interface UrgentMessageRepository extends JpaRepository<UrgentMessage, Long>, CustomUrgentMessageRepository{

}
