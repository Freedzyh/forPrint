package com.github.xuejike.springboot.print.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 2082215121L;

    public static final QUser user = new QUser("user");

    public final NumberPath<Long> companyId = createNumber("companyId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nickName = createString("nickName");

    public final EnumPath<com.github.xuejike.springboot.print.entity.enumType.Status> status = createEnum("status", com.github.xuejike.springboot.print.entity.enumType.Status.class);

    public final StringPath userName = createString("userName");

    public final StringPath userPassword = createString("userPassword");

    public final EnumPath<com.github.xuejike.springboot.print.entity.enumType.UserType> userType = createEnum("userType", com.github.xuejike.springboot.print.entity.enumType.UserType.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

