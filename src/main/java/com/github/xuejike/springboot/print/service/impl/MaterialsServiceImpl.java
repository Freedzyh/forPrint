package com.github.xuejike.springboot.print.service.impl;

import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.hibernate.lambda.core.LambdaCriteria;
import com.github.xuejike.springboot.print.dao.MaaterialsDao;
import com.github.xuejike.springboot.print.entity.Materials;
import com.github.xuejike.springboot.print.service.MaterialsService;
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
public class MaterialsServiceImpl extends BaseServiceImpl<Materials> implements MaterialsService {
    @Autowired
    private MaaterialsDao maaterialsDao;

    public LambdaCriteria getLambda(Materials materials) {
        LambdaCriteria<Materials> materialsLambdaCriteria = lambdaQuery.create(Materials.class);
        if (!Strings.isNullOrEmpty(materials.getName())) {
            materialsLambdaCriteria.like(q -> {
                q.setName("%" + materials.getName() + "%");
            });
        }
        return materialsLambdaCriteria;
    }

    @Override
    public void queryLike(Materials materials, Page<Materials> page) {
        LambdaCriteria<Materials> materialsLambdaCriteria = getLambda(materials);
        List<Materials> list = materialsLambdaCriteria.orderDesc("id").list(page.getPageCurrent(), page.getPageSize());
        Long count = materialsLambdaCriteria.count();
        page.setList(list);
        page.setTotal(count);
    }

    public void checkMater(Materials materials) {
        checkString(materials.getName(), "材料名称不能为空");
        checkString(materials.getMessage(), "备注信息不能为空");
        checkString(materials.getPrice(), "单价不能为空");
        checkString(materials.getSize(), "规格不能为空");
        checkString(materials.getStock(), "库存数量不能为空");
        checkString(materials.getUnit(), "单位不能为空");
    }

    @Override
    public void insert(Materials materials) {
        checkMater(materials);
        maaterialsDao.save(materials);

    }

    @Override
    public void update(Materials materials) {
        Materials materialsInfo = maaterialsDao.findFirstById(materials.getId());
        if (materialsInfo != null) {
            materialsInfo.setName(materials.getName());
            materialsInfo.setMessage(materials.getMessage());
            materialsInfo.setPrice(materials.getPrice());
            materialsInfo.setSize(materials.getSize());
            materialsInfo.setStock(materials.getStock());
            materialsInfo.setUnit(materials.getUnit());
            maaterialsDao.save(materialsInfo);
        }
    }

    @Override
    public void delete(Long id) {
        maaterialsDao.delete(id);
    }

    @Override
    protected JpaRepository getDao() {
        return maaterialsDao;
    }
}
