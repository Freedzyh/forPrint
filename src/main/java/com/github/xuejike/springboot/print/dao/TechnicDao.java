package com.github.xuejike.springboot.print.dao;

import com.github.xuejike.springboot.jkfaststart.repository.BaseJPA;
import com.github.xuejike.springboot.print.entity.Technic;
import com.github.xuejike.springboot.print.entity.enumType.TechincType;

import java.util.List;

/**
 * Created by xuemingyu 2018/3/27
 */
public interface TechnicDao extends BaseJPA<Technic> {
    Technic findFirstById(Long id);

    List<Technic> findAllByTechincType(TechincType techincType);

    List<Technic> findAllByProcessTechnogyId(String processTechnogyId);
}
