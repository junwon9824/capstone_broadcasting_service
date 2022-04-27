package com.timcook.capstone.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Admin extends User{
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VILLAGE_ID")
	private Village village;
	
	@OneToMany	
	private List<File> files;
	
	public Admin(String username, String email, Role role, Device device, User guardian, Village village) {
		super(username, email, role, device, guardian);
		this.village = village;
	}
	
	public static User toUser(Admin admin) {
		return User.builder()
					.username(admin.getUsername())
					.email(admin.getEmail())
					.role(Role.ROLE_USER)
					.device(admin.getDevice())
					.guardian(admin.getGuardian())
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
