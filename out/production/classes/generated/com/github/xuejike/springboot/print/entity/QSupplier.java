package com.github.xuejike.springboot.print.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSupplier is a Querydsl query type for Supplier
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSupplier extends EntityPathBase<Supplier> {

    private static final long serialVersionUID = -531025966L;

    public static final QSupplier supplier = new QSupplier("supplier");

    public final StringPath account = createString("account");

    public final StringPath address = createString("address");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath message = createString("message");

    public final StringPath mobilePhone = createString("mobilePhone");

    public final StringPath name = createString("name");

    public final StringPath openBank = createString("openBank");

    public final StringPath paymentMethod = createString("paymentMethod");

    public final StringPath qq = createString("qq");

    public final StringPath telephone = createString("telephone");

    public QSupplier(String variable) {
        super(Supplier.class, forVariable(variable));
    }

    public QSupplier(Path<? extends Supplier> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSupplier(PathMetadata metadata) {
        super(Supplier.class, metadata);
    }

}

