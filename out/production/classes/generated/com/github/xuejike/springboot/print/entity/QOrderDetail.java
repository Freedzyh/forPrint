package com.github.xuejike.springboot.print.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderDetail is a Querydsl query type for OrderDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderDetail extends EntityPathBase<OrderDetail> {

    private static final long serialVersionUID = 246881657L;

    public static final QOrderDetail orderDetail = new QOrderDetail("orderDetail");

    public final StringPath auxfunUnit = createString("auxfunUnit");

    public final StringPath auxfunValue = createString("auxfunValue");

    public final StringPath component = createString("component");

    public final NumberPath<Long> count = createNumber("count", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> orderId = createNumber("orderId", Long.class);

    public final StringPath processTechnology = createString("processTechnology");

    public final StringPath size = createString("size");

    public final StringPath type = createString("type");

    public final StringPath unit = createString("unit");

    public QOrderDetail(String variable) {
        super(OrderDetail.class, forVariable(variable));
    }

    public QOrderDetail(Path<? extends OrderDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderDetail(PathMetadata metadata) {
        super(OrderDetail.class, metadata);
    }

}

