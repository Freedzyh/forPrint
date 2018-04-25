package com.github.xuejike.springboot.print.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSysConfig is a Querydsl query type for SysConfig
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSysConfig extends EntityPathBase<SysConfig> {

    private static final long serialVersionUID = 476490537L;

    public static final QSysConfig sysConfig = new QSysConfig("sysConfig");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isDelete = createBoolean("isDelete");

    public final EnumPath<com.github.xuejike.springboot.print.entity.enumType.SysType> sysType = createEnum("sysType", com.github.xuejike.springboot.print.entity.enumType.SysType.class);

    public final StringPath val = createString("val");

    public QSysConfig(String variable) {
        super(SysConfig.class, forVariable(variable));
    }

    public QSysConfig(Path<? extends SysConfig> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysConfig(PathMetadata metadata) {
        super(SysConfig.class, metadata);
    }

}

