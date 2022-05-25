package com.timcook.capstone.device.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.timcook.capstone.device.dto.QUnconfirmResponse is a Querydsl Projection type for UnconfirmResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUnconfirmResponse extends ConstructorExpression<UnconfirmResponse> {

    private static final long serialVersionUID = -1299165599L;

    public QUnconfirmResponse(com.querydsl.core.types.Expression<java.time.LocalDateTime> createdTime) {
        super(UnconfirmResponse.class, new Class<?>[]{java.time.LocalDateTime.class}, createdTime);
    }

}

