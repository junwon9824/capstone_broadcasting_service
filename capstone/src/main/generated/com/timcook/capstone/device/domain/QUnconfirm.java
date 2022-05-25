package com.timcook.capstone.device.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUnconfirm is a Querydsl query type for Unconfirm
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUnconfirm extends EntityPathBase<Unconfirm> {

    private static final long serialVersionUID = 615691989L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUnconfirm unconfirm = new QUnconfirm("unconfirm");

    public final DateTimePath<java.time.LocalDateTime> createdTime = createDateTime("createdTime", java.time.LocalDateTime.class);

    public final QDevice device;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QUnconfirm(String variable) {
        this(Unconfirm.class, forVariable(variable), INITS);
    }

    public QUnconfirm(Path<? extends Unconfirm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUnconfirm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUnconfirm(PathMetadata metadata, PathInits inits) {
        this(Unconfirm.class, metadata, inits);
    }

    public QUnconfirm(Class<? extends Unconfirm> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.device = inits.isInitialized("device") ? new QDevice(forProperty("device"), inits.get("device")) : null;
    }

}

