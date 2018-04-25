package com.github.xuejike.springboot.jkfaststart.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAdminPermission is a Querydsl query type for AdminPermission
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAdminPermission extends EntityPathBase<AdminPermission> {

    private static final long serialVersionUID = 188904417L;

    public static final QAdminPermission adminPermission = new QAdminPermission("adminPermission");

    public final StringPath description = createString("description");

    public final StringPath icon = createString("icon");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath method = createString("method");

    public final StringPath name = createString("name");

    public final NumberPath<Long> pid = createNumber("pid", Long.class);

    public final NumberPath<Integer> sortIndex = createNumber("sortIndex", Integer.class);

    public final ListPath<AdminPermission, QAdminPermission> subMenu = this.<AdminPermission, QAdminPermission>createList("subMenu", AdminPermission.class, QAdminPermission.class, PathInits.DIRECT2);

    public final EnumPath<com.github.xuejike.springboot.jkfaststart.domain.type.PermissionType> type = createEnum("type", com.github.xuejike.springboot.jkfaststart.domain.type.PermissionType.class);

    public final StringPath url = createString("url");

    public QAdminPermission(String variable) {
        super(AdminPermission.class, forVariable(variable));
    }

    public QAdminPermission(Path<? extends AdminPermission> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdminPermission(PathMetadata metadata) {
        super(AdminPermission.class, metadata);
    }

}

