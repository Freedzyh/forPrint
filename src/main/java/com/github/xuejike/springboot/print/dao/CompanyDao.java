package com.github.xuejike.springboot.print.dao;

import com.github.xuejike.springboot.jkfaststart.repository.BaseJPA;
import com.github.xuejike.springboot.print.entity.Company;

/**
 * Created by xuemingyu 2018/3/26
 */
public interface CompanyDao extends BaseJPA<Company> {
    Company findFirstById(Long id);
}
