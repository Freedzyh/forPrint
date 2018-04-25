package com.github.xuejike.springboot.jkfaststart.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAdminRole is a Querydsl query type for AdminRole
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAdminRole extends EntityPathBase<AdminRole> {

    private static final long serialVersionUID = 1890231304L;

    public static final QAdminRole adminRole = new QAdminRole("adminRole");

    public final BooleanPath delete = createBoolean("delete");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath info = createString("info");

    public final StringPath name = createString("name");

    public final SetPath<AdminPermission, QAdminPermission> permissionSet = this.<AdminPermission, QAdminPermission>createSet("permissionSet", AdminPermission.class, QAdminPermission.class, PathInits.DIRECT2);

    public QAdminRole(String variable) {
        super(AdminRole.class, forVariable(variable));
    }

    public QAdminRole(Path<? extends AdminRole> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminRole(PathMetadata metadata) {
        super(AdminRole.class, metadata);
    }

}

