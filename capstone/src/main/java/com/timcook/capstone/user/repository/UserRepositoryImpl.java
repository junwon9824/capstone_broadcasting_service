package com.timcook.capstone.user.repository;

import java.util.List;

import static com.timcook.capstone.user.domain.QUser.user;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.timcook.capstone.user.dto.QUserResponse;
import com.timcook.capstone.user.dto.UserResponse;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements CustomUserRepository{

	private final JPAQueryFactory queryFactory;
	
	@Override
	public List<UserResponse> searchBy(String username) {
		return queryFactory.select(new QUserResponse(
								user.id, user.username, user.email, user.role, user.phoneNumber, user.address))
							.from(user)
							.where(user.username.eq(username))
							.fetch();
	}

	
	
}
