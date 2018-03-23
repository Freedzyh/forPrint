package com.github.xuejike.springboot.print.service.impl;

import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.hibernate.lambda.core.LambdaCriteria;
import com.github.xuejike.springboot.print.dao.ComposeDao;
import com.github.xuejike.springboot.print.entity.Compose;
import com.github.xuejike.springboot.print.service.ComposeService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by xuemingyu 2018/3/22
 */
@Service
@Transactional
public class ComposeServiceImpl extends BaseServiceImpl<Compose> implements ComposeService {
    @Autowired
    private ComposeDao composeDao;

    public LambdaCriteria getLambda(Compose compose) {
        LambdaCriteria<Compose> lambdaCriteria = lambdaQuery.create(Compose.class);
        if (!Strings.isNullOrEmpty(compose.getName())) {
            lambdaCriteria.like(q -> {
                q.setName("%" + compose.getName() + "%");
            });
        }
        return lambdaCriteria;
    }

    @Override
    public void queryLike(Compose compose, Page<Compose> page) {
        LambdaCriteria<Compose> lambdaCriteria = getLambda(compose);
        List<Compose> list = lambdaCriteria.orderDesc("id").list(page.getPageCurrent(), page.getPageSize());
        Long count = lambdaCriteria.count();
        page.setList(list);
        page.setTotal(count);
    }

    @Override
    public void insert(Compose compose) {
        checkString(compose.getName(), "排版方式名称不能为空");
        composeDao.save(compose);
    }

    @Override
    public void update(Compose compose) {
        checkString(compose.getName(), "排版方式名称不能为空");
        Compose composeInfo = composeDao.findFirstById(compose.getId());
        if (composeInfo != null) {
            composeInfo.setName(compose.getName());
            composeDao.save(composeInfo);
        }
    }

    @Override
    public void delete(Long id) {
        composeDao.delete(id);
    }

    @Override
    protected JpaRepository getDao() {
        return composeDao;
    }
}
