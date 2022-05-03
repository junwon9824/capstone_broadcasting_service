package com.timcook.capstone.user.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1388651470L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final com.timcook.capstone.device.domain.QDevice device;

    public final StringPath email = createString("email");

    public final QUser guardian;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<Role> role = createEnum("role", Role.class);

    public final StringPath username = createString("username");

    public final com.timcook.capstone.village.domain.QVillage village;

    public final ListPath<User, QUser> wards = this.<User, QUser>createList("wards", User.class, QUser.class, PathInits.DIRECT2);

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.device = inits.isInitialized("device") ? new com.timcook.capstone.device.domain.QDevice(forProperty("device"), inits.get("device")) : null;
        this.guardian = inits.isInitialized("guardian") ? new QUser(forProperty("guardian"), inits.get("guardian")) : null;
        this.village = inits.isInitialized("village") ? new com.timcook.capstone.village.domain.QVillage(forProperty("village"), inits.get("village")) : null;
    }

}

