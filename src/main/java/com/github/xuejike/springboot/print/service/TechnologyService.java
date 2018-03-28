package com.github.xuejike.springboot.print.service;

import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.entity.Technology;

import java.util.List;

/**
 * Created by xuemingyu 2018/3/27
 */
public interface TechnologyService extends BaseService<Technology> {
    void queryLike(Technology technology, Page<Technology> page);

    void insert(Technology technology);

    void update(Technology technology);

    void delete(Long id);

    List<Technology> findAll();
}
