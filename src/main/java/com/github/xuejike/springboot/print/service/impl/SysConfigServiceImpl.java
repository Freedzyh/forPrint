package com.github.xuejike.springboot.print.service.impl;

import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.hibernate.lambda.core.LambdaCriteria;
import com.github.xuejike.springboot.print.dao.SysConfigDao;
import com.github.xuejike.springboot.print.entity.SysConfig;
import com.github.xuejike.springboot.print.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SysConfigServiceImpl extends BaseServiceImpl<SysConfig> implements SysConfigService {


    @Autowired
    SysConfigDao sysConfigDao;

    @Override
    protected JpaRepository<SysConfig, Long> getDao() {
        return sysConfigDao;
    }


    @Override
    public void queryLike(SysConfig query, Page<SysConfig> page) {
        LambdaCriteria<SysConfig> lambdaCriteria = lambdaQuery.create(SysConfig.class);
        List<SysConfig> list = lambdaCriteria.orderDesc("id")
                                .list(page.getPageCurrent(), page.getPageSize());
        Long count = lambdaCriteria.count();
        page.setTotal(count);
        page.setList(list);
    }


    @Override
    public void update(SysConfig sysConfig) {

    }

    @Override
    public void delete(Long id) {

    }


}
