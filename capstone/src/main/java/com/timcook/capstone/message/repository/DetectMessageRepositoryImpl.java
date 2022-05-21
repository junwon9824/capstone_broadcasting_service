package com.timcook.capstone.message.repository;

import java.util.List;

import static com.timcook.capstone.message.domain.QDetectMessage.detectMessage;
import static com.timcook.capstone.device.domain.QDevice.device;
import static com.timcook.capstone.user.domain.QUser.user;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.timcook.capstone.message.domain.DetectMessage;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DetectMessageRepositoryImpl implements CustomDetectMessageRepository{

	private final JPAQueryFactory jpaQueryFactory;
	
	@Override
	public List<DetectMessage> findAllMessagesByUserId(Long userId) {
		
		return  jpaQueryFactory
					.selectFrom(detectMessage)
					.join(detectMessage.device, device).fetchJoin()
					.join(device.user, user).fetchJoin()
					.where(detectMessage.device.user.id.eq(userId))
					.fetch();
	}

	
	
}
