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

@Repository
@RequiredArgsConstructor
public class AdminRepositoryImpl implements CustomAdminRepository{

	private final JPAQueryFactory jpaQueryFactory;
	
	@Override
	public List<FileResponse> findAllFiles(Long id) {
		
		Admin findAdmin = jpaQueryFactory
									.selectFrom(admin)
									.join(admin.files, file).fetchJoin()
									.where(admin.id.eq(id))
									.fetchOne();
		return findAdmin.getFiles().stream()
						.map(f -> FileResponse.from(f))
						.collect(Collectors.toList());
	}

}
