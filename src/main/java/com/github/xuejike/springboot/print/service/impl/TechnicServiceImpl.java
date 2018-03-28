package com.github.xuejike.springboot.print.service.impl;

import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.hibernate.lambda.core.LambdaCriteria;
import com.github.xuejike.springboot.print.dao.TechnicDao;
import com.github.xuejike.springboot.print.entity.Technic;
import com.github.xuejike.springboot.print.entity.enumType.TechincType;
import com.github.xuejike.springboot.print.service.TechnicService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuemingyu 2018/3/27
 */
@Service
@Transactional
public class TechnicServiceImpl extends BaseServiceImpl<Technic> implements TechnicService {
    @Autowired
    private TechnicDao technicDao;


    public LambdaCriteria getLambda(Technic technic) {
        LambdaCriteria<Technic> technicLambdaCriteria = lambdaQuery.create(Technic.class);
        if (!Strings.isNullOrEmpty(technic.getName())) {
            technicLambdaCriteria.like(q -> {
                q.setName("%" + technic.getName() + "%");
            });
        }
        return technicLambdaCriteria;
    }

    @Override
    public void queryLike(Technic technic, Page<Technic> page) {
        LambdaCriteria<Technic> lambdaCriteria = getLambda(technic);
        List<Technic> list = lambdaCriteria.orderDesc("id").list(page.getPageCurrent(), page.getPageSize());
        Long count = lambdaCriteria.count();
        page.setList(list);
        page.setTotal(count);
    }

    @Override
    public void insert(Technic technic) {
        technicDao.save(technic);
    }

    @Override
    public void delete(Long id) {
        technicDao.delete(id);
    }

    @Override
    public List<Technic> findByTechincTypeAndId(String id) {
        checkNull(id, "id不能为空");
        Technic technic = technicDao.findOne(Long.valueOf(id));
        LambdaCriteria<Technic> lambdaCriteria = lambdaQuery.create(Technic.class);
        String str = "," + id + ",";
        switch (technic.getTechincType()) {
            case processTechnogy:
                lambdaCriteria.like(q -> {
                    q.setProcessTechnogyId("%" + str + "%");
                });
            case cabinet:
                lambdaCriteria.like(q -> {
                    q.setCabinetId("%" + str + "%");
                });
        }
        return lambdaCriteria.list();
    }


    @Override
    public List<Technic> findByParentIdsAndTechnicType(TechincType techincType) {
        return technicDao.findAllByTechincType(techincType);
    }

    @Override
    public List<Technic> findCabinetByCabinetId(String cabinetId) {
        String[] split = cabinetId.split(",");
        List<Technic> list = new ArrayList<>();
        for (String tempId : split) {
            list.add(technicDao.findOne(Long.valueOf(tempId)));
        }
        return list;
    }

    @Override
    protected JpaRepository<Technic, Long> getDao() {
        return technicDao;
    }
}
