package com.github.xuejike.springboot.print.service;

import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.entity.Compose;

/**
 * Created by xuemingyu 2018/3/22
 */
public interface ComposeService extends BaseService<Compose> {
    void queryLike(Compose compose, Page<Compose> page);

    void insert(Compose compose);

    void update(Compose compose);

    void delete(Long id);
}
