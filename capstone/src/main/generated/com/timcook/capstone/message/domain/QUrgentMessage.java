package com.timcook.capstone.message.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUrgentMessage is a Querydsl query type for UrgentMessage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUrgentMessage extends EntityPathBase<UrgentMessage> {

    private static final long serialVersionUID = -989950909L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUrgentMessage urgentMessage = new QUrgentMessage("urgentMessage");

    public final DateTimePath<java.time.LocalDateTime> createdTime = createDateTime("createdTime", java.time.LocalDateTime.class);

    public final com.timcook.capstone.device.domain.QDevice device;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QUrgentMessage(String variable) {
        this(UrgentMessage.class, forVariable(variable), INITS);
    }

    public QUrgentMessage(Path<? extends UrgentMessage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUrgentMessage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUrgentMessage(PathMetadata metadata, PathInits inits) {
        this(UrgentMessage.class, metadata, inits);
    }

    public QUrgentMessage(Class<? extends UrgentMessage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.device = inits.isInitialized("device") ? new com.timcook.capstone.device.domain.QDevice(forProperty("device"), inits.get("device")) : null;
    }

}

