package com.github.xuejike.springboot.jkfaststart.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAdminUser is a Querydsl query type for AdminUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAdminUser extends EntityPathBase<AdminUser> {

    private static final long serialVersionUID = 1890324317L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAdminUser adminUser = new QAdminUser("adminUser");

    public final QAdminRole adminRole;

    public final DateTimePath<org.joda.time.DateTime> createTime = createDateTime("createTime", org.joda.time.DateTime.class);

    public final BooleanPath delete = createBoolean("delete");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nickName = createString("nickName");

    public final StringPath pwd = createString("pwd");

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    public final EnumPath<com.github.xuejike.springboot.jkfaststart.domain.type.Status> status = createEnum("status", com.github.xuejike.springboot.jkfaststart.domain.type.Status.class);

    public final DateTimePath<org.joda.time.DateTime> updateTime = createDateTime("updateTime", org.joda.time.DateTime.class);

    public final StringPath username = createString("username");

    public QAdminUser(String variable) {
        this(AdminUser.class, forVariable(variable), INITS);
    }

    public QAdminUser(Path<? extends AdminUser> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAdminUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAdminUser(PathMetadata metadata, PathInits inits) {
        this(AdminUser.class, metadata, inits);
    }

    public QAdminUser(Class<? extends AdminUser> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.adminRole = inits.isInitialized("adminRole") ? new QAdminRole(forProperty("adminRole")) : null;
    }

}

