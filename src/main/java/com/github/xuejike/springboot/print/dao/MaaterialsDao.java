package com.github.xuejike.springboot.print.dao;

import com.github.xuejike.springboot.jkfaststart.repository.BaseJPA;
import com.github.xuejike.springboot.print.entity.Materials;

/**
 * Created by xuemingyu 2018/3/22
 */
public interface MaaterialsDao extends BaseJPA<Materials> {
    Materials findFirstById(Long id);

    Materials findFirstByName(String name);

}
