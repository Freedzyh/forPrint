package com.github.xuejike.springboot.print.service;

import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.entity.Technic;
import com.github.xuejike.springboot.print.entity.enumType.TechincType;

import java.util.List;

/**
 * Created by xuemingyu 2018/3/27
 */
public interface TechnicService extends BaseService<Technic> {
    void queryLike(Technic technic, Page<Technic> page);

    void insert(Technic technic);

    void delete(Long id);

    List<Technic> findByTechincTypeAndId(String id);


    List<Technic> findByParentIdsAndTechnicType(TechincType techincType);

    List<Technic> findCabinetByCabinetId(String cabinetId);

}
