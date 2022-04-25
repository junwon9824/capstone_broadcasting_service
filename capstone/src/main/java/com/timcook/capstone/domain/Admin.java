package com.timcook.capstone.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Admin extends User{
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VILLAGE_ID")
	private Village village;
	
	
}
