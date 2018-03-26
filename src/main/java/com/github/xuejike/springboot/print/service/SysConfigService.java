package com.github.xuejike.springboot.print.service;

import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.entity.SysConfig;

public interface SysConfigService extends BaseService<SysConfig> {


    void queryLike(SysConfig query, Page<SysConfig> page);
}
