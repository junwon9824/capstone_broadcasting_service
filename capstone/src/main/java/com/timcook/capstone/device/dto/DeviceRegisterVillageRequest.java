package com.timcook.capstone.device.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeviceRegisterVillageRequest {

	@NotNull
	private Long villageId;

	@Builder
	public DeviceRegisterVillageRequest(Long villageId) {
		this.villageId = villageId;
	}
}
