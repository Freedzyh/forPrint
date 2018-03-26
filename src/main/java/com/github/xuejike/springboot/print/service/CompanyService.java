package com.github.xuejike.springboot.print.service;

import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.entity.Company;

/**
 * Created by xuemingyu 2018/3/26
 */
public interface CompanyService extends BaseService<Company> {
    void queryLike(Company company, Page<Company> page);

    void insert(Company company);

    void update(Company company);

    void delete(Long id);
}
