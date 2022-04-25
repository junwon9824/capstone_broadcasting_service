package com.timcook.capstone.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Address {

	@NotNull
	@Column(length = 30)
	@Size(max = 30)
	private String city;
	
	@NotNull
	@Column(length = 30)
	@Size(max = 30)
	private String zipcode;
	
	@NotNull
	@Column(length = 30)
	@Size(max = 30)
	private String street;
}
