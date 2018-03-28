package com.github.xuejike.springboot.print.service.impl;

import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.hibernate.lambda.core.LambdaCriteria;
import com.github.xuejike.springboot.print.dao.SysConfigDao;
import com.github.xuejike.springboot.print.entity.SysConfig;
import com.github.xuejike.springboot.print.entity.dto.SysTypeDto;
import com.github.xuejike.springboot.print.entity.enumType.SysType;
import com.github.xuejike.springboot.print.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
    public List<Object> getList() {
        List<Object> list = new ArrayList<>();

        for (SysType sysType : SysType.values()) {
            SysTypeDto temp = new SysTypeDto();
            temp.setName(sysType.cn());
            temp.setVal(sysType);

            list.add(temp);
        }


        return list;
    }

    @Override
    public void queryLike(SysConfig query, Page<SysConfig> page) {
        LambdaCriteria<SysConfig> lambdaCriteria = lambdaQuery.create(SysConfig.class);

//        lambdaCriteria.eqExample(query);

        List<SysConfig> list = lambdaCriteria.orderDesc("id")
                                .list(page.getPageCurrent(), page.getPageSize());
        Long count = lambdaCriteria.count();
        page.setTotal(count);
        page.setList(list);
    }


    @Override
    public void update(SysConfig sysConfig) {
        checkNull(sysConfig.getId(),"id不能为空");
        checkNull(sysConfig.getVal(),"参数值不能为空");
        SysConfig temp = sysConfigDao.findOne(sysConfig.getId());
        temp.setVal(sysConfig.getVal());
        sysConfigDao.save(temp);
    }

    @Override
    public void delete(Long id) {
        checkNull(id,"id不能为空");
        SysConfig temp = sysConfigDao.findOne(id);
        temp.setDelete(true);
        sysConfigDao.save(temp);
    }


}
