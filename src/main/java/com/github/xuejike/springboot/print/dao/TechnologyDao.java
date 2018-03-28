package com.github.xuejike.springboot.print.dao;

import com.github.xuejike.springboot.jkfaststart.repository.BaseJPA;
import com.github.xuejike.springboot.print.entity.Technology;

import java.util.List;

/**
 * Created by xuemingyu 2018/3/27
 */
public interface TechnologyDao extends BaseJPA<Technology> {
    Technology findFirstById(Long id);

    Technology findFirstByCabinet(String cabinet);

    Technology findFirstByProcessMethod(String processMethod);

    Technology findFirstByProcessTechnogy(String processTechnogy);
}
