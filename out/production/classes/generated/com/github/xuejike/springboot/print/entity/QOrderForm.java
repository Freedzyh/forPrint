package com.github.xuejike.springboot.print.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderForm is a Querydsl query type for OrderForm
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrderForm extends EntityPathBase<OrderForm> {

    private static final long serialVersionUID = 348929004L;

    public static final QOrderForm orderForm = new QOrderForm("orderForm");

    public final StringPath address = createString("address");

    public final StringPath companyName = createString("companyName");

    public final StringPath count = createString("count");

    public final StringPath deliveryTime = createString("deliveryTime");

    public final StringPath getOrSend = createString("getOrSend");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath message = createString("message");

    public final StringPath name = createString("name");

    public final StringPath pageCount = createString("pageCount");

    public final StringPath phone = createString("phone");

    public final StringPath size = createString("size");

    public final StringPath task = createString("task");

    public final StringPath technology = createString("technology");

    public QOrderForm(String variable) {
        super(OrderForm.class, forVariable(variable));
    }

    public QOrderForm(Path<? extends OrderForm> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderForm(PathMetadata metadata) {
        super(OrderForm.class, metadata);
    }

}

