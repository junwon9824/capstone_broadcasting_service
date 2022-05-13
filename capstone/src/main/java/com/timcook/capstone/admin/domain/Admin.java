package com.timcook.capstone.admin.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.timcook.capstone.device.domain.Device;
import com.timcook.capstone.file.domain.File;
import com.timcook.capstone.user.domain.Role;
import com.timcook.capstone.user.domain.User;
import com.timcook.capstone.village.domain.Address;
import com.timcook.capstone.village.domain.Village;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin extends User{
	
	@OneToMany(mappedBy = "admin", orphanRemoval = true)	
	private List<File> files = new ArrayList<>();
	
	public Admin(String username, String password, String email, Role role, 
			Device device, User ward, Village village, String phoneNumber, Address address) {
		super(username, password, email, role, device, ward, village, phoneNumber, address);
	}
	
	public User toUser() {
		return User.builder()
					.username(this.getUsername())
					.password(this.getPassword())
					.email(this.getEmail())
					.role(Role.ROLE_USER)
					.device(this.getDevice())
					.ward(this.getWard())
					.village(this.getVillage())
					.phoneNumber(this.getPhoneNumber())
					.address(this.getAddress())
					.build();
	}
	
	
	public void registerVillage(Village village) {
		if(Objects.isNull(this.village)) {
			this.village=village;
			this.village.updateAdmin(this);
		}else {
			throw new IllegalStateException("이미 관리중인 마을이 있습니다.");
		}
	}
	
	public void removeVillage() {
		if(!Objects.isNull(this.village)) {
			this.village = null;
		}
	}
	
	public void addFile(File file) {
		this.files.add(file);
	}
}
