package com.timcook.capstone.village.repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.timcook.capstone.village.domain.QVillage.village;
import static com.timcook.capstone.device.domain.QDevice.device;
import static com.timcook.capstone.user.domain.QUser.user;
import static com.timcook.capstone.file.domain.QFile.file;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.timcook.capstone.village.domain.QVillage;
import com.timcook.capstone.device.domain.QDevice;
import com.timcook.capstone.user.domain.QUser;
import com.timcook.capstone.user.dto.UserResponse;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.timcook.capstone.device.dto.DeviceResponse;
import com.timcook.capstone.device.dto.QDeviceResponse;
import com.timcook.capstone.file.dto.FileResponse;
import com.timcook.capstone.file.dto.QFileResponse;
import com.timcook.capstone.file.repository.FileRepository;
import com.timcook.capstone.village.domain.Village;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class VillageRepositoryImpl implements CustomVillageRepository{

	private final JPAQueryFactory jpaQueryFactory;
	private final FileRepository fileRepository;
	
	@Override
	public List<DeviceResponse> findAllDevices(Long id) {
	
		Village findVillage = jpaQueryFactory
								.select(village)
								.from(village)
								.join(village.devices, device).fetchJoin()
								.join(device.user, user).fetchJoin()
								.where(village.id.eq(id))
								.fetchOne();
		log.info("=Village -> DeviceResponse=");
		return findVillage.getDevices().stream()
						.map(d -> DeviceResponse.from(d))
						.collect(Collectors.toList());
	}

	@Transactional
	@Override
	public List<FileResponse> findAllFiles(Long id) {
		Village findVillage = jpaQueryFactory
				.select(village)
				.from(village)
				.leftJoin(village.files, file).fetchJoin()
				.where(village.id.eq(id))
				.fetchOne();

		return findVillage.getFiles().stream()
						.map(f -> FileResponse.from(f))
						.collect(Collectors.toList());
	}

	@Transactional
	@Override
	public List<UserResponse> findAllUsers(Long id) {
		Village findVillage = jpaQueryFactory
				.select(village)
				.from(village)
				.leftJoin(village.users, user).fetchJoin()
				.where(village.id.eq(id))
				.fetchOne();
		return findVillage.getUsers().stream()
						.map(u -> UserResponse.from(u))
						.collect(Collectors.toList());
	}	
}
