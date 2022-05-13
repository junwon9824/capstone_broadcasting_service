package com.timcook.capstone.user.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.timcook.capstone.admin.domain.Admin;
import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.user.dto.UserUpdateRequest;
import com.timcook.capstone.village.domain.Address;
import com.timcook.capstone.village.domain.Village;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
	
	@Id @GeneratedValue
	@Column(name = "USER_ID")
	@NotNull
	private Long id;
	
	@Column(length = 10, nullable = false)
	@Size(max = 10)
	@NotNull
	private String username;
	
	private String password;
	
	@Column(length = 11)
	private String phoneNumber;
	
	@NotNull
	@Column(length = 30, nullable = false)
	@Size(max = 30)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@NotNull
	private Role role;
	
	@OneToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "DEVICE_ID")
	private Device device;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "WARD_USER_ID")
	private User ward;
	
	@OneToMany(mappedBy = "ward")
	private List<User> guardians = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VILLAGE_ID")
	protected Village village;
	
	@Embedded
	private Address address;
	
	@Builder
	public User(String username, String password, String email, Role role, 
			Device device, User ward, Village village, String phoneNumber, Address address) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.device = device;
		this.ward = ward;
		this.village = village;
		this.phoneNumber = phoneNumber;
		this.address = address;		
	}
	
	public void changeInfo(UserUpdateRequest userUpdateRequest) {
		this.username = userUpdateRequest.getUsername();
		this.device = userUpdateRequest.getDevice();
		this.email = userUpdateRequest.getEmail();
	}
	
	public void addGaurdian(User guardian) {
		guardian.registerWard(this);
		this.guardians.add(guardian);
	}
	
	public Admin toAdmin() {
		return new Admin(this.username, this.password, this.email, Role.ROLE_ADMIN,
				this.device, this.ward, this.village, this.phoneNumber, this.address);
	}
	
	public void registerVillage(Village village) {
		if(Objects.isNull(this.village)) {
			this.village=village;
			this.village.addUser(this);
		}else {
			throw new IllegalStateException("이미 구독중인 마을이 있습니다.");
		}
	}
	
	public void registerDevice(Device device) {
		if(Objects.isNull(this.device)) {
			this.device=device;
		}else {
			throw new IllegalStateException("이미 사용중인 단말기가 있습니다.");
		}
	}
	
	public void removeVillage() {
		if(!Objects.isNull(this.village)) {
			this.village.removeUser(this);
			this.village = null;
		}
	}
	
	private void registerWard(User ward) {
		this.ward = ward;
	}
}
