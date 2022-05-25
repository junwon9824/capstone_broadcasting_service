package com.timcook.capstone.device.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDisabled is a Querydsl query type for Disabled
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDisabled extends EntityPathBase<Disabled> {

    private static final long serialVersionUID = 343448558L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDisabled disabled = new QDisabled("disabled");

    public final DateTimePath<java.time.LocalDateTime> createdTime = createDateTime("createdTime", java.time.LocalDateTime.class);

    public final QDevice device;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QDisabled(String variable) {
        this(Disabled.class, forVariable(variable), INITS);
    }

    public QDisabled(Path<? extends Disabled> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDisabled(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDisabled(PathMetadata metadata, PathInits inits) {
        this(Disabled.class, metadata, inits);
    }

    public QDisabled(Class<? extends Disabled> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.device = inits.isInitialized("device") ? new QDevice(forProperty("device"), inits.get("device")) : null;
    }

}

