package com.timcook.capstone.admin.repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.timcook.capstone.file.domain.QFile.file;
import static com.timcook.capstone.admin.domain.QAdmin.admin;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.timcook.capstone.admin.domain.Admin;
import com.timcook.capstone.file.dto.FileResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class AdminRepositoryImpl implements CustomAdminRepository{

	private final JPAQueryFactory jpaQueryFactory;
	
	@Override
	public List<FileResponse> findAllFiles(Long id) {
		
		Admin findAdmin = jpaQueryFactory
									.selectFrom(admin)
									.where(admin.id.eq(id))
									.fetchOne();
		
		log.info("findAdmin = {}",findAdmin.getUsername());
		
		return findAdmin.getFiles().stream()
						.map(f -> FileResponse.from(f))
						.collect(Collectors.toList());
	}

}
