package com.timcook.capstone.message.repository.urgent;

import static com.timcook.capstone.message.domain.QUrgentMessage.urgentMessage;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.message.dto.QUrgentMessageReponse;
import com.timcook.capstone.message.dto.UrgentMessageReponse;
import com.timcook.capstone.user.domain.User;
import com.timcook.capstone.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UrgentMessageRepositoryImpl implements CustomUrgentMessageRepository{

	private final JPAQueryFactory jpaQueryFactory;
	private final UserRepository userRepository;
	
	@Override
	public List<UrgentMessageReponse> findAllByUserId(Long userId) {
		
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
		
		Device device = user.getDevice();
		if(device == null) {
			throw new IllegalArgumentException("회원의 단말기가 없습니다.");
		}
		
		return jpaQueryFactory.selectFrom(urgentMessage)
					.where(urgentMessage.device.id.eq(device.getId()))
					.fetch()
					.stream()
					.map(m -> UrgentMessageReponse.from(m))
					.collect(Collectors.toList());
	}

//	private BooleanExpression deviceEq(Device device) {
//		return device
//	}
	
	
}
