package com.timcook.capstone.message.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.timcook.capstone.admin.domain.Admin;
import com.timcook.capstone.device.domain.Device;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DetectMessage extends AbstractMessage{

	@Id @GeneratedValue
	@Column(name = "MESSAGE_ID")
	@NotNull
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEVICE_ID")
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
	public DetectMessage(Device device, Double temperature, Double humidity,
			Boolean detectionVibration, Boolean detectionGasLeak, Boolean detectionAbnomalness) {
		this.device = device;
		this.temperature = temperature;
		this.humidity = humidity;
		this.detectionVibration = detectionVibration;
		this.detectionGasLeak = detectionGasLeak;
		this.detectionAbnomalness = detectionAbnomalness;
	}

	@Override
	public String toString() {
		return "[DEVICE] : " + this.device.getId() + " /[TEMP] : " + this.temperature
				+ " /[HUM] : " + this.humidity + " /[VIBRATION] : " + this.detectionVibration
				+ " /[GASLEAK] : " + this.detectionGasLeak + " /[ABNOMALNESS] : " + this.detectionAbnomalness;
	}
	
	
}
