package com.github.xuejike.springboot.print.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTechnic is a Querydsl query type for Technic
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTechnic extends EntityPathBase<Technic> {

    private static final long serialVersionUID = 2062633196L;

    public static final QTechnic technic = new QTechnic("technic");

    public final StringPath cabinetId = createString("cabinetId");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> levelId = createNumber("levelId", Long.class);

    public final StringPath name = createString("name");

    public final StringPath processMethodId = createString("processMethodId");

    public final StringPath processTechnogyId = createString("processTechnogyId");

    public final EnumPath<com.github.xuejike.springboot.print.entity.enumType.TechincType> techincType = createEnum("techincType", com.github.xuejike.springboot.print.entity.enumType.TechincType.class);

    public QTechnic(String variable) {
        super(Technic.class, forVariable(variable));
    }

    public QTechnic(Path<? extends Technic> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTechnic(PathMetadata metadata) {
        super(Technic.class, metadata);
    }

}

