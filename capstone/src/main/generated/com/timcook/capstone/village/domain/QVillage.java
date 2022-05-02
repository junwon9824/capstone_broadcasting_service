package com.timcook.capstone.village.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVillage is a Querydsl query type for Village
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVillage extends EntityPathBase<Village> {

    private static final long serialVersionUID = -240757276L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVillage village = new QVillage("village");

    public final QAddress address;

    public final com.timcook.capstone.admin.domain.QAdmin admin;

    public final ListPath<com.timcook.capstone.device.domain.Device, com.timcook.capstone.device.domain.QDevice> devices = this.<com.timcook.capstone.device.domain.Device, com.timcook.capstone.device.domain.QDevice>createList("devices", com.timcook.capstone.device.domain.Device.class, com.timcook.capstone.device.domain.QDevice.class, PathInits.DIRECT2);

    public final ListPath<com.timcook.capstone.file.domain.File, com.timcook.capstone.file.domain.QFile> files = this.<com.timcook.capstone.file.domain.File, com.timcook.capstone.file.domain.QFile>createList("files", com.timcook.capstone.file.domain.File.class, com.timcook.capstone.file.domain.QFile.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nickname = createString("nickname");

    public final ListPath<com.timcook.capstone.user.domain.User, com.timcook.capstone.user.domain.QUser> users = this.<com.timcook.capstone.user.domain.User, com.timcook.capstone.user.domain.QUser>createList("users", com.timcook.capstone.user.domain.User.class, com.timcook.capstone.user.domain.QUser.class, PathInits.DIRECT2);

    public QVillage(String variable) {
        this(Village.class, forVariable(variable), INITS);
    }

    public QVillage(Path<? extends Village> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVillage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVillage(PathMetadata metadata, PathInits inits) {
        this(Village.class, metadata, inits);
    }

    public QVillage(Class<? extends Village> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new QAddress(forProperty("address")) : null;
        this.admin = inits.isInitialized("admin") ? new com.timcook.capstone.admin.domain.QAdmin(forProperty("admin"), inits.get("admin")) : null;
    }

}

