package com.timcook.capstone.village.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.timcook.capstone.village.dto.QVillageResponse is a Querydsl Projection type for VillageResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QVillageResponse extends ConstructorExpression<VillageResponse> {

    private static final long serialVersionUID = -1150814308L;

    public QVillageResponse(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> nickname, com.querydsl.core.types.Expression<? extends com.timcook.capstone.admin.dto.AdminResponse> admin, com.querydsl.core.types.Expression<String> city, com.querydsl.core.types.Expression<String> state, com.querydsl.core.types.Expression<String> town, com.querydsl.core.types.Expression<? extends com.timcook.capstone.village.domain.Location> location) {
        super(VillageResponse.class, new Class<?>[]{long.class, String.class, com.timcook.capstone.admin.dto.AdminResponse.class, String.class, String.class, String.class, com.timcook.capstone.village.domain.Location.class}, id, nickname, admin, city, state, town, location);
    }

}

