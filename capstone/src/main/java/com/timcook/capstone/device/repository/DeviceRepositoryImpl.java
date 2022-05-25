package com.timcook.capstone.device.repository;

import java.util.List;

import static com.timcook.capstone.device.domain.QDisabled.disabled;
import static com.timcook.capstone.device.domain.QUnconfirm.unconfirm;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.timcook.capstone.device.dto.DisabledResponse;
import com.timcook.capstone.device.dto.QDisabledResponse;
import com.timcook.capstone.device.dto.QUnconfirmResponse;
import com.timcook.capstone.device.dto.UnconfirmResponse;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DeviceRepositoryImpl implements CustomDeviceRepository{
	
	private final JPAQueryFactory jpaQueryFactory;
	
	@Override
	public List<DisabledResponse> getDisabled(Long deviceId) {
		return jpaQueryFactory.select(new QDisabledResponse(disabled.createdTime))
						.from(disabled)
						.where(disabled.device.id.eq(deviceId))
						.fetch();
	}

	@Override
	public List<UnconfirmResponse> getUnconfirm(Long deviceId) {
		return jpaQueryFactory.select(new QUnconfirmResponse(unconfirm.createdTime))
				.from(unconfirm)
				.where(unconfirm.device.id.eq(deviceId))
				.fetch();
	}

}
