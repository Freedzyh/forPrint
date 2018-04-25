package com.github.xuejike.springboot.print.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCompose is a Querydsl query type for Compose
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompose extends EntityPathBase<Compose> {

    private static final long serialVersionUID = 155738828L;

    public static final QCompose compose = new QCompose("compose");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QCompose(String variable) {
        super(Compose.class, forVariable(variable));
    }

    public QCompose(Path<? extends Compose> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCompose(PathMetadata metadata) {
        super(Compose.class, metadata);
    }

}

