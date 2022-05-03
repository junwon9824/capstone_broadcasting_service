package com.timcook.capstone.admin.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAdmin is a Querydsl query type for Admin
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAdmin extends EntityPathBase<Admin> {

    private static final long serialVersionUID = -745397052L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAdmin admin = new QAdmin("admin");

    public final com.timcook.capstone.user.domain.QUser _super;

    // inherited
    public final com.timcook.capstone.device.domain.QDevice device;

    //inherited
    public final StringPath email;

    public final ListPath<com.timcook.capstone.file.domain.File, com.timcook.capstone.file.domain.QFile> files = this.<com.timcook.capstone.file.domain.File, com.timcook.capstone.file.domain.QFile>createList("files", com.timcook.capstone.file.domain.File.class, com.timcook.capstone.file.domain.QFile.class, PathInits.DIRECT2);

    // inherited
    public final com.timcook.capstone.user.domain.QUser guardian;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final EnumPath<com.timcook.capstone.user.domain.Role> role;

    //inherited
    public final StringPath username;

    public final com.timcook.capstone.village.domain.QVillage village;

    //inherited
    public final ListPath<com.timcook.capstone.user.domain.User, com.timcook.capstone.user.domain.QUser> wards;

    public QAdmin(String variable) {
        this(Admin.class, forVariable(variable), INITS);
    }

    public QAdmin(Path<? extends Admin> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAdmin(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAdmin(PathMetadata metadata, PathInits inits) {
        this(Admin.class, metadata, inits);
    }

    public QAdmin(Class<? extends Admin> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new com.timcook.capstone.user.domain.QUser(type, metadata, inits);
        this.device = _super.device;
        this.email = _super.email;
        this.guardian = _super.guardian;
        this.id = _super.id;
        this.role = _super.role;
        this.username = _super.username;
        this.village = inits.isInitialized("village") ? new com.timcook.capstone.village.domain.QVillage(forProperty("village"), inits.get("village")) : null;
        this.wards = _super.wards;
    }

}

