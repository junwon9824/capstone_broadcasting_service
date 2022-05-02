package com.timcook.capstone.message.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDetectMessage is a Querydsl query type for DetectMessage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDetectMessage extends EntityPathBase<DetectMessage> {

    private static final long serialVersionUID = -1158543711L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDetectMessage detectMessage = new QDetectMessage("detectMessage");

    public final DateTimePath<java.time.LocalDateTime> createdTime = createDateTime("createdTime", java.time.LocalDateTime.class);

    public final BooleanPath detectionAbnormalness = createBoolean("detectionAbnormalness");

    public final BooleanPath detectionGasLeak = createBoolean("detectionGasLeak");

    public final BooleanPath detectionVibration = createBoolean("detectionVibration");

    public final com.timcook.capstone.device.domain.QDevice device;

    public final NumberPath<Double> humidity = createNumber("humidity", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> temperature = createNumber("temperature", Double.class);

    public QDetectMessage(String variable) {
        this(DetectMessage.class, forVariable(variable), INITS);
    }

    public QDetectMessage(Path<? extends DetectMessage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDetectMessage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDetectMessage(PathMetadata metadata, PathInits inits) {
        this(DetectMessage.class, metadata, inits);
    }

    public QDetectMessage(Class<? extends DetectMessage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.device = inits.isInitialized("device") ? new com.timcook.capstone.device.domain.QDevice(forProperty("device"), inits.get("device")) : null;
    }

}

