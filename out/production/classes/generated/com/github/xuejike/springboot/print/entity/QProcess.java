package com.github.xuejike.springboot.print.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProcess is a Querydsl query type for Process
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProcess extends EntityPathBase<Process> {

    private static final long serialVersionUID = -1104277591L;

    public static final QProcess process = new QProcess("process");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> pid = createNumber("pid", Long.class);

    public QProcess(String variable) {
        super(Process.class, forVariable(variable));
    }

    public QProcess(Path<? extends Process> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProcess(PathMetadata metadata) {
        super(Process.class, metadata);
    }

}

