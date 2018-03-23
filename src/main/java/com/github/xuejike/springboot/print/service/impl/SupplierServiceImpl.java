package com.github.xuejike.springboot.print.service.impl;

import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.hibernate.lambda.core.LambdaCriteria;
import com.github.xuejike.springboot.print.dao.SupplierDao;
import com.github.xuejike.springboot.print.entity.Supplier;
import com.github.xuejike.springboot.print.service.SupplierService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by xuemingyu 2018/3/21
 */
@Service
@Transactional
public class SupplierServiceImpl extends BaseServiceImpl<Supplier> implements SupplierService {
    @Autowired
    private SupplierDao supplierDao;

    public LambdaCriteria getLambda(Supplier supplier) {
        LambdaCriteria<Supplier> supplierLambdaCriteria = lambdaQuery.create(Supplier.class);
        if (!Strings.isNullOrEmpty(supplier.getName())) {
            supplierLambdaCriteria.like(q -> {
                q.setName("%" + supplier.getName() + "%");
            });
        }
        if (!Strings.isNullOrEmpty(supplier.getMobilePhone())) {
            supplierLambdaCriteria.like(q -> {
                q.setMobilePhone("%" + supplier.getMobilePhone() + "%");
            });
        }
        if (!Strings.isNullOrEmpty(supplier.getQq())) {
            supplierLambdaCriteria.like(q -> {
                q.setQq("%" + supplier.getQq() + "%");
            });
        }
        if (!Strings.isNullOrEmpty(supplier.getTelephone())) {
            supplierLambdaCriteria.like(q -> {
                q.setTelephone("%" + supplier.getTelephone() + "%");
            });
        }
        return supplierLambdaCriteria;
    }

    @Override
    public void queryLike(Supplier supplier, Page<Supplier> page) {
        LambdaCriteria<Supplier> supplierLambdaCriteria = getLambda(supplier);
        List<Supplier> list = supplierLambdaCriteria.orderDesc("id").list(page.getPageCurrent(), page.getPageSize());
        Long count = supplierLambdaCriteria.count();
        page.setTotal(count);
        page.setList(list);
    }

    public void checkSupplier(Supplier supplier) {
        checkString(supplier.getName(), "供应商名称不能为空");
        checkPhone(supplier.getMobilePhone(), "请输入正确的手机号");
        checkString(supplier.getQq(), "QQ号码不能为空");
        checkString(supplier.getTelephone(), "固定电话不能为空");
        checkString(supplier.getAddress(), "地址不能为空");
        checkString(supplier.getAccount(), "账号不能为空");
        checkString(supplier.getOpenBank(), "开户行不能为空");
        checkString(supplier.getPaymentMethod(), "付款方式不能为空");
    }

    @Override
    public void insert(Supplier supplier) {
        checkSupplier(supplier);
        supplierDao.save(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        checkSupplier(supplier);
        Supplier supplierInfo = supplierDao.findFirstById(supplier.getId());
        if (supplierInfo != null) {
            supplierInfo.setName(supplier.getName());
            supplierInfo.setTelephone(supplier.getTelephone());
            supplierInfo.setQq(supplier.getQq());
            supplierInfo.setMobilePhone(supplier.getMobilePhone());
            supplierInfo.setAccount(supplier.getAccount());
            supplierInfo.setAddress(supplier.getAddress());
            supplierInfo.setOpenBank(supplier.getOpenBank());
            supplierInfo.setPaymentMethod(supplier.getPaymentMethod());
            supplierInfo.setMessage(supplier.getMessage());
            supplierDao.save(supplierInfo);

        }
    }

    @Override
    public void delete(Long id) {
        supplierDao.delete(id);
    }

    @Override
    protected JpaRepository<Supplier, Long> getDao() {
        return supplierDao;
    }
}
