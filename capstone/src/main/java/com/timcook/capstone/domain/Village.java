package com.timcook.capstone.domain;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Village {

	@Id @GeneratedValue
	@Column(name = "VILLAGE_ID")
	@NotNull
	private Long id;
	
	@OneToOne(mappedBy = "village",fetch = FetchType.LAZY)
	private Admin admin;
	
	@OneToMany(mappedBy = "village")
	private List<Device> devices = new ArrayList<>();
	
	@OneToMany(mappedBy = "village")
	private List<File> files = new ArrayList<>();
	
	@Embedded
	private Address address;
	
	@Builder
	public Village(Admin admin, List<Device> devices, Address address) {
		this.admin = admin;
		this.devices = devices;
		this.address = address;
	}
	
	public void addDevice(Device device) {
		this.devices.add(device);
	}
	
	public void updateAdmin(Admin admin) {
		this.admin = admin;
	}
}
