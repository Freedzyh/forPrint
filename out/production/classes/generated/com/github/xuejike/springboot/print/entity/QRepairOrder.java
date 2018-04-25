package com.github.xuejike.springboot.print.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRepairOrder is a Querydsl query type for RepairOrder
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRepairOrder extends EntityPathBase<RepairOrder> {

    private static final long serialVersionUID = 713747451L;

    public static final QRepairOrder repairOrder = new QRepairOrder("repairOrder");

    public final StringPath assistCount = createString("assistCount");

    public final StringPath assistFormat = createString("assistFormat");

    public final StringPath assistProcess = createString("assistProcess");

    public final StringPath assistSize = createString("assistSize");

    public final StringPath assistSource = createString("assistSource");

    public final StringPath cabinet = createString("cabinet");

    public final StringPath captainSign = createString("captainSign");

    public final StringPath estimateCount = createString("estimateCount");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath mainCount = createString("mainCount");

    public final StringPath mainName = createString("mainName");

    public final StringPath mainSource = createString("mainSource");

    public final StringPath openCount = createString("openCount");

    public final StringPath paperSize = createString("paperSize");

    public final StringPath printCount = createString("printCount");

    public final StringPath productionProcess = createString("productionProcess");

    public final StringPath productionRequire = createString("productionRequire");

    public final StringPath receiverSign = createString("receiverSign");

    public final StringPath releaseCount = createString("releaseCount");

    public QRepairOrder(String variable) {
        super(RepairOrder.class, forVariable(variable));
    }

    public QRepairOrder(Path<? extends RepairOrder> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRepairOrder(PathMetadata metadata) {
        super(RepairOrder.class, metadata);
    }

}

