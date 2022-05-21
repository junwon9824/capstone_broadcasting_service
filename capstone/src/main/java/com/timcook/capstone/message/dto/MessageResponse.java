package com.timcook.capstone.message.dto;

import java.time.LocalDateTime;

import com.timcook.capstone.message.domain.DetectMessage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {

	private double temperature;
	private double humidity;
	private LocalDateTime detect_time;
	
	
	public static MessageResponse from(DetectMessage detectMessage) {
		return MessageResponse.builder()
							.temperature(detectMessage.getTemperature())
							.humidity(detectMessage.getHumidity())
							.detect_time(detectMessage.getCreatedTime())
							.build();
	}
}
