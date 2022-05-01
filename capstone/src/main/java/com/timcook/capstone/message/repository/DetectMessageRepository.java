package com.timcook.capstone.message.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timcook.capstone.message.domain.DetectMessage;

public interface DetectMessageRepository extends JpaRepository<DetectMessage, Long>{

}
