package com.timcook.capstone.message.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.timcook.capstone.message.dto.QUrgentMessageReponse is a Querydsl Projection type for UrgentMessageReponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QUrgentMessageReponse extends ConstructorExpression<UrgentMessageReponse> {

    private static final long serialVersionUID = -1222280706L;

    public QUrgentMessageReponse(com.querydsl.core.types.Expression<Long> userId, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdTime) {
        super(UrgentMessageReponse.class, new Class<?>[]{long.class, java.time.LocalDateTime.class}, userId, createdTime);
    }

}

