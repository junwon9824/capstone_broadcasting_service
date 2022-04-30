package com.timcook.capstone.device.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.timcook.capstone.message.domain.Message;
import com.timcook.capstone.user.domain.User;
import com.timcook.capstone.user.dto.UserUpdateRequest;
import com.timcook.capstone.village.domain.Village;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Device {
	
	@Id @GeneratedValue
	@Column(name = "DEVICE_ID")
	@NotNull
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VILLAGE_ID")
	private Village village;

	@OneToOne(mappedBy = "device",fetch = FetchType.LAZY)
	private User user;
	
	@OneToMany(mappedBy = "device")
	private List<Message> messages;

	@Builder
	public Device(Village village, User user) {
		this.village = village;
		this.user = user;
	}
	
	public void addMessage(Message message) {
		this.messages.add(message);
	}
	
	
	public void changeInfo(User user, Village village) {
		changeUser(user);
		changeVillage(village);
	}
	
	private void changeUser(User user) {
		if(Objects.isNull(this.user)) {
			this.user = user;
			this.user.changeInfo(UserUpdateRequest.from(user));
		}
	}
	
	private void changeVillage(Village village) {
		if(Objects.isNull(this.village)) {
			this.village = village;
			this.village.addDevice(this);
		}
	}
	
}
