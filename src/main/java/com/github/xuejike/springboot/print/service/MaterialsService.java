package com.github.xuejike.springboot.print.service;

import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.entity.Materials;

/**
 * Created by xuemingyu 2018/3/22
 */
public interface MaterialsService extends BaseService<Materials> {
    void queryLike(Materials materials, Page<Materials> page);

    void insert(Materials materials);

    void update(Materials materials);

    void delete(Long id);
}
