package com.timcook.capstone.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.timcook.capstone.admin.service.AdminService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MqttUtils {

	private static final String EMERGENCY = "emergency";
	private final AdminService adminService;
	
	public void payloadToMessage(String payload) {
		if(isUrgent(payload)) {
			
		}else {
			
		}
	}
	
	private boolean isUrgent(String payload){
		List<String> result = new ArrayList<>(Arrays.asList(payload.split("/"))); 
		if(result.get(0) == EMERGENCY) {
			return true;
		}
		return false;
	}
	
	private void publishUrgent() {
		
	}
	
	private void publishNo
}
