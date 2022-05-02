package com.timcook.capstone.village.repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.timcook.capstone.village.domain.QVillage.village;
import static com.timcook.capstone.device.domain.QDevice.device;
import static com.timcook.capstone.user.domain.QUser.user;

import org.springframework.stereotype.Repository;

import com.timcook.capstone.village.domain.QVillage;
import com.timcook.capstone.device.domain.QDevice;
import com.timcook.capstone.user.domain.QUser;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.timcook.capstone.device.dto.DeviceResponse;
import com.timcook.capstone.device.dto.QDeviceResponse;
import com.timcook.capstone.village.domain.Village;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class VillageRepositoryImpl implements CustomVillageRepository{

	private final JPAQueryFactory jpaQueryFactory;
	
	@Override
	public List<DeviceResponse> findAllDevices(Long id) {
	
		Village findVillage = jpaQueryFactory
								.select(village)
								.from(village)
								.join(village.devices, device).fetchJoin()
								.join(device.user, user).fetchJoin()
								.where(village.id.eq(id))
								.fetchOne();
		
		return findVillage.getDevices().stream()
						.map(d -> DeviceResponse.from(d))
						.collect(Collectors.toList());
	}	
	
	
	
}