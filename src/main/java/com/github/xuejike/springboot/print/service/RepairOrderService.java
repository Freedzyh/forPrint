package com.github.xuejike.springboot.print.service;

import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.entity.RepairOrder;

/**
 * Created by xuemingyu 2018/3/22
 */
public interface RepairOrderService extends BaseService<RepairOrder> {
    void queryLike(RepairOrder repairOrder, Page<RepairOrder> page);

    void insert(RepairOrder repairOrder);

    void update(RepairOrder repairOrder);

    void delete(Long id);
}
