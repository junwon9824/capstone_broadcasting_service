package com.timcook.capstone.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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

import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
	
	@Id @GeneratedValue
	@Column(name = "USER_ID")
	@NotNull
	private Long id;
	
	@Column(length = 10)
	@Size(max = 10)
	@NotNull
	private String username;
	
	@NotNull
	@Column(length = 30)
	@Size(max = 30)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private Role role;
	
	@OneToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "DEVICE_ID")
	private Device device;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GUAR_USER_ID")
	private User guardian;
	
	@OneToMany(mappedBy = "guardian")
	private List<User> wards = new ArrayList<>();
}
