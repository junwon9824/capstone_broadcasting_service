package com.timcook.capstone.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Admin extends User{
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VILLAGE_ID")
	private Village village;

	public Admin(String username, String email, Role role) {
		super(username, email, role);
	}
	
	public static User toUser(Admin admin) {
		return new User(admin.getUsername(), admin.getEmail(), Role.USER);
	}
}
