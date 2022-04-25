package com.timcook.capstone.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
public class Message {

	@Id @GeneratedValue
	@Column(name = "MESSAGE_ID")
	@NotNull
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEVICE_ID")
	private Device device;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UESR_ID")
	@NotNull
	private Admin admin;
	
	@NotNull
	private Double temperature;
	@NotNull
	private Double humidity;
	@NotNull
	private Boolean detectionVibration;
	@NotNull
	private Boolean detectionGasLeak;
}
