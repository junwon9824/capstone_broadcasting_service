package com.timcook.capstone.village.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class Address {

	@NotNull
	@Column(length=30)
	@Size(max=30)
	private String state; // 시,도 e.g) 경기도, 서울특별시, ...
	
	@NotNull
	@Column(length = 30)
	@Size(max = 30)
	private String city; // 면,읍,구,군,시 e.g) 하남시, 강남구, ... 
 	
	@NotNull
	@Column(length = 30)
	@Size(max = 30)
	private String town; // 동 e.g) 하남동, 삼성동, ...  
	
}
