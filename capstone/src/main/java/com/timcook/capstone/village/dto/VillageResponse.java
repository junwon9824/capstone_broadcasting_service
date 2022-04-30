package com.timcook.capstone.village.dto;

import java.util.Objects;

import com.timcook.capstone.admin.domain.Admin;
import com.timcook.capstone.admin.dto.AdminResponse;
import com.timcook.capstone.village.domain.Address;
import com.timcook.capstone.village.domain.Village;

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
		if(Objects.isNull(village.getAdmin())) {
			return new VillageResponse(village.getId(), null, village.getAddress());
		}
		else {
			return new VillageResponse(village.getId(), AdminResponse.from(village.getAdmin()), village.getAddress());
		}
	}
}
