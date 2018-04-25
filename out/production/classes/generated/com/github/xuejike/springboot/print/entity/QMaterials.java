package com.github.xuejike.springboot.print.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMaterials is a Querydsl query type for Materials
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMaterials extends EntityPathBase<Materials> {

    private static final long serialVersionUID = 1422052070L;

    public static final QMaterials materials = new QMaterials("materials");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath message = createString("message");

    public final StringPath name = createString("name");

    public final StringPath price = createString("price");

    public final StringPath size = createString("size");

    public final StringPath Stock = createString("Stock");

    public final StringPath unit = createString("unit");

    public QMaterials(String variable) {
        super(Materials.class, forVariable(variable));
    }

    public QMaterials(Path<? extends Materials> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMaterials(PathMetadata metadata) {
        super(Materials.class, metadata);
    }

}

