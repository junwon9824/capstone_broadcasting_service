package com.timcook.capstone.device.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.timcook.capstone.device.dto.QDeviceResponse is a Querydsl Projection type for DeviceResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QDeviceResponse extends ConstructorExpression<DeviceResponse> {

    private static final long serialVersionUID = 371296350L;

    public QDeviceResponse(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<? extends com.timcook.capstone.user.dto.UserResponse> userResponse) {
        super(DeviceResponse.class, new Class<?>[]{long.class, com.timcook.capstone.user.dto.UserResponse.class}, id, userResponse);
    }

}

