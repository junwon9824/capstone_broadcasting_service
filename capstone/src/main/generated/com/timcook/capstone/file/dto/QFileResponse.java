package com.timcook.capstone.file.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * com.timcook.capstone.file.dto.QFileResponse is a Querydsl Projection type for FileResponse
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QFileResponse extends ConstructorExpression<FileResponse> {

    private static final long serialVersionUID = 1052668126L;

    public QFileResponse(com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> contents, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdTime) {
        super(FileResponse.class, new Class<?>[]{String.class, String.class, java.time.LocalDateTime.class}, title, contents, createdTime);
    }

}

