package com.github.xuejike.springboot.print.service;

import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.entity.Supplier;

/**
 * Created by xuemingyu 2018/3/21
 */
public interface SupplierService extends BaseService<Supplier> {
    void queryLike(Supplier supplier, Page<Supplier> page);

    void insert(Supplier supplier);

    void update(Supplier supplier);

    void delete(Long id);
}
