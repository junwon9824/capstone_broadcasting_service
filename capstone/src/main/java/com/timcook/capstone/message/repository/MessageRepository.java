package com.timcook.capstone.message.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timcook.capstone.message.domain.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

}
