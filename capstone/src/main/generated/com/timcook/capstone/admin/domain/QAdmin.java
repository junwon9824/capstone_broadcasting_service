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
    public final com.timcook.capstone.village.domain.QAddress address;

    // inherited
    public final com.timcook.capstone.device.domain.QDevice device;

    //inherited
    public final StringPath email;

    public final ListPath<com.timcook.capstone.file.domain.File, com.timcook.capstone.file.domain.QFile> files = this.<com.timcook.capstone.file.domain.File, com.timcook.capstone.file.domain.QFile>createList("files", com.timcook.capstone.file.domain.File.class, com.timcook.capstone.file.domain.QFile.class, PathInits.DIRECT2);

    //inherited
    public final ListPath<com.timcook.capstone.user.domain.User, com.timcook.capstone.user.domain.QUser> guardians;

    //inherited
    public final NumberPath<Long> id;

    //inherited
    public final StringPath password;

    //inherited
    public final StringPath phoneNumber;

    //inherited
    public final EnumPath<com.timcook.capstone.user.domain.Role> role;

    //inherited
    public final StringPath username;

    // inherited
    public final com.timcook.capstone.village.domain.QVillage village;

    // inherited
    public final com.timcook.capstone.user.domain.QUser ward;

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
        this.address = _super.address;
        this.device = _super.device;
        this.email = _super.email;
        this.guardians = _super.guardians;
        this.id = _super.id;
        this.password = _super.password;
        this.phoneNumber = _super.phoneNumber;
        this.role = _super.role;
        this.username = _super.username;
        this.village = _super.village;
        this.ward = _super.ward;
    }

}

