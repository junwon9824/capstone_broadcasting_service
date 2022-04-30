package com.timcook.capstone.message.domain;

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

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UrgentMessage extends AbstractMessage{
	
	@Id @GeneratedValue
	@Column(name = "MESSAGE_ID")
	@NotNull
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEVICE_ID")
	private Device device;

	@Builder
	public UrgentMessage(Device device) {
		this.device = device;
	}
	
	
}
