package com.timcook.capstone.village.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timcook.capstone.device.dto.DeviceResponse;
import com.timcook.capstone.village.domain.Village;

public interface VillageRepository extends JpaRepository<Village, Long>, CustomVillageRepository{

	
}
