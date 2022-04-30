package com.timcook.capstone.message.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.message.domain.AbstractMessage;
import com.timcook.capstone.message.domain.DetectMessage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DetectMessageCreateRequest implements MessageCreateRequsetInterface{

	@NotNull
	private Device device;
	@NotNull
	private Double temperature;
	@NotNull
	private Double humidity;
	@NotNull
	private Boolean detectionVibration;
	@NotNull
	private Boolean detectionGasLeak;
	@NotNull
	private Boolean detectionAbnomalness;
	
	@Builder
	public DetectMessageCreateRequest(Device device, Double temperature, Double humidity,
			Boolean detectionVibration, Boolean detectionGasLeak, Boolean detectionAbnomalness) {
		this.device = device;
		this.temperature = temperature;
		this.humidity = humidity;
		this.detectionVibration = detectionVibration;
		this.detectionGasLeak = detectionGasLeak;
		this.detectionAbnomalness = detectionAbnomalness;
	}
	
	public DetectMessageCreateRequest (List<String> payload) {
		this.temperature = Double.valueOf(payload.get(1));
		this.humidity = Double.valueOf(payload.get(2));
		this.detectionVibration = Boolean.valueOf(payload.get(3));
		this.detectionGasLeak = Boolean.valueOf(payload.get(4));
		this.detectionAbnomalness = Boolean.valueOf(payload.get(5));
	}

	public DetectMessage toEntity() {
		return DetectMessage.builder()
				.device(device)
				.temperature(temperature)
				.humidity(humidity)
				.detectionVibration(detectionVibration)
				.detectionGasLeak(detectionGasLeak)
				.detectionAbnomalness(detectionAbnomalness)
				.build();
	}
}
