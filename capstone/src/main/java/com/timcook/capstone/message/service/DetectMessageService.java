package com.timcook.capstone.message.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timcook.capstone.message.domain.DetectMessage;
import com.timcook.capstone.message.dto.DetectMessageCreateRequest;
import com.timcook.capstone.message.repository.DetectMessageRepository;
import com.timcook.capstone.notification.dto.NotificationRequest;
import com.timcook.capstone.notification.service.NotificationService;
import com.timcook.capstone.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DetectMessageService{

	private final DetectMessageRepository detectMessageRepository;
	private final NotificationService notificationService;
	
	@Transactional
	public DetectMessage create(DetectMessageCreateRequest createRequest) {
		return detectMessageRepository.save(createRequest.toEntity());
	}
	
	public void sendToMessage(DetectMessage detectMessage) {
		User deviceUser = detectMessage.getDevice().getUser();
		List<User> guardians = deviceUser.getGuardians();
		List<NotificationRequest> notificationRequests = makeNoticiation(detectMessage);
		
		for(User guardian : guardians) {
			for(NotificationRequest notification : notificationRequests) {
				notification.setToken(notificationService.getToken(guardian.getId()));
				notificationService.sendNotification(notification);
			}
		}
	}
	
	private List<NotificationRequest> makeNoticiation(DetectMessage detectMessage) {
		List<NotificationRequest> results = new ArrayList<>();
		
		if(detectMessage.getDetectionVibration()) {
			results.add(new NotificationRequest(null, "지진 감지 알림", "지진이 감지되었습니다"));
		}
		if(detectMessage.getDetectionGasLeak()) {
			results.add(new NotificationRequest(null, "가스 누출 알림", "가스 누출이 감지되었습니다"));
		}
		if(detectMessage.getDetectionAbnormalness()) {
			results.add(new NotificationRequest(null, "이상행동 감지 알림", "이상행동이 감지되었습니다"));
		}
		
		return results;
	}
	
}
