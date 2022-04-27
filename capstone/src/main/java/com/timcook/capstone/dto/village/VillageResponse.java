package com.timcook.capstone.dto.village;

import com.timcook.capstone.domain.Address;
import com.timcook.capstone.domain.Admin;
import com.timcook.capstone.domain.Village;
import com.timcook.capstone.dto.admin.AdminResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VillageResponse {
	
	private Long id;
	private AdminResponse adminResponse;
	private Address address;
	
	public static VillageResponse from(Village village) {
		return new VillageResponse(village.getId(), AdminResponse.from(village.getAdmin()), village.getAddress());
	}
}
