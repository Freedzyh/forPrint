package com.github.xuejike.springboot.print.service;

import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.entity.SysConfig;

import java.util.List;

public interface SysConfigService extends BaseService<SysConfig> {



    List<Object> getList();


    void queryLike(SysConfig query, Page<SysConfig> page);


    void update(SysConfig sysConfig);


    void delete(Long id);


}
