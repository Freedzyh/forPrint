package com.github.xuejike.springboot.print.service.impl;

import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.hibernate.lambda.core.LambdaCriteria;
import com.github.xuejike.springboot.print.dao.TechnologyDao;
import com.github.xuejike.springboot.print.entity.Technology;
import com.github.xuejike.springboot.print.service.TechnologyService;
import com.github.xuejike.springboot.print.utils.TechnologyType;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by xuemingyu 2018/3/27
 */
@Service
@Transactional
public class TechnologyServiceImpl extends BaseServiceImpl<Technology> implements TechnologyService {
    @Autowired
    private TechnologyDao technologyDao;

    public LambdaCriteria getLambda(Technology technology) {
        LambdaCriteria<Technology> technologyLambdaCriteria = lambdaQuery.create(Technology.class);
        if (!Strings.isNullOrEmpty(technology.getCabinet())) {
            technologyLambdaCriteria.like(q -> {
                q.setCabinet("%" + technology.getCabinet() + "%");
            });
        }
        if (!Strings.isNullOrEmpty(technology.getProcessMethod())) {
            technologyLambdaCriteria.like(q -> {
                q.setProcessMethod("%" + technology.getProcessMethod() + "%");
            });
        }
        if (!Strings.isNullOrEmpty(technology.getProcessTechnogy())) {
            technologyLambdaCriteria.like(q -> {
                q.setProcessTechnogy("%" + technology.getProcessTechnogy() + "%");
            });
        }
        return technologyLambdaCriteria;
    }

    @Override
    public void queryLike(Technology technology, Page<Technology> page) {
        LambdaCriteria<Technology> lambdaCriteria = getLambda(technology);
        List<Technology> list = lambdaCriteria.orderDesc("id").list(page.getPageCurrent(), page.getPageSize());
        Long count = lambdaCriteria.count();
        page.setTotal(count);
        page.setList(list);
    }

    public void checkT(Technology technology) {
        checkString(technology.getCabinet(), "机台不能为空");
        checkString(technology.getProcessMethod(), "加工方式不能为空");
        checkString(technology.getProcessTechnogy(), "加工技术不能为空");
    }

    @Override
    public void insert(Technology technology) {
        checkT(technology);
        technologyDao.save(technology);
    }

    @Override
    public void update(Technology technology) {
        checkT(technology);
        Technology technologyInfo = technologyDao.findFirstById(technology.getId());
        technologyInfo.setProcessMethod(technology.getProcessMethod());
        technologyInfo.setProcessTechnogy(technology.getProcessTechnogy());
        technologyInfo.setCabinet(technology.getCabinet());
        technologyDao.save(technologyInfo);
    }

    @Override
    public List<Technology> findAll() {
        List<Technology> technologies = technologyDao.findAll();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < technologies.size(); i++) {
            list.add(technologies.get(i).getProcessTechnogy());
        }
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        List<TechnologyType> technologyTypes = new ArrayList<>();
        for (int j = 0; j < list.size(); j++) {
            TechnologyType technologyType = new TechnologyType();
            technologyType.setProcessTechnogy(list.get(j));
            technologyTypes.add(technologyType);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        technologyDao.delete(id);
    }

    @Override
    protected JpaRepository<Technology, Long> getDao() {
        return technologyDao;
    }
}
