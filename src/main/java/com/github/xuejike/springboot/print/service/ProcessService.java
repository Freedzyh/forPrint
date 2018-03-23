package com.github.xuejike.springboot.print.service;

import com.bidanet.bdcms.core.vo.Page;
import com.github.xuejike.springboot.print.entity.Process;

/**
 * Created by xuemingyu 2018/3/22
 */
public interface ProcessService extends BaseService<Process> {
    void queryLike(Process process, Page<Process> page);

    void insert(Process process);

    void update(Process process);

    void delete(Long id);
}
