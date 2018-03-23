package com.github.xuejike.springboot.print.dao;

import com.github.xuejike.springboot.jkfaststart.repository.BaseJPA;
import com.github.xuejike.springboot.print.entity.Compose;

/**
 * Created by xuemingyu 2018/3/22
 */
public interface ComposeDao extends BaseJPA<Compose> {
    Compose findFirstById(Long id);

    Compose findFirstByName(String name);
}
