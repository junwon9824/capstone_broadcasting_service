package com.timcook.capstone.domain;

import java.util.ArrayList;
import java.util.List;

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

import lombok.NoArgsConstructor;

@Entity
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
	
	
}
