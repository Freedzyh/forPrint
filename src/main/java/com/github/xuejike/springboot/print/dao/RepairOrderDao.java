package com.github.xuejike.springboot.print.dao;

import com.github.xuejike.springboot.jkfaststart.repository.BaseJPA;
import com.github.xuejike.springboot.print.entity.RepairOrder;

/**
 * Created by xuemingyu 2018/3/22
 */
public interface RepairOrderDao extends BaseJPA<RepairOrder> {
    RepairOrder findFirstById(Long id);
}
