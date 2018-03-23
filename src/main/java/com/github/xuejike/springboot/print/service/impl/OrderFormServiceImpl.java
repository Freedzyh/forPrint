package com.github.xuejike.springboot.print.service.impl;

import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.hibernate.lambda.core.LambdaCriteria;
import com.github.xuejike.springboot.print.dao.OrderFormDao;
import com.github.xuejike.springboot.print.entity.OrderForm;
import com.github.xuejike.springboot.print.service.OrderFormService;
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
public class OrderFormServiceImpl extends BaseServiceImpl<OrderForm> implements OrderFormService {
    @Autowired
    private OrderFormDao orderFormDao;

    public LambdaCriteria getLambda(OrderForm orderForm) {
        LambdaCriteria<OrderForm> orderFormLambdaCriteria = lambdaQuery.create(OrderForm.class);
        if (!Strings.isNullOrEmpty(orderForm.getName())) {
            orderFormLambdaCriteria.like(q -> {
                q.setName("%" + orderForm.getName() + "%");
            });
        }
        if (!Strings.isNullOrEmpty(orderForm.getCompanyName())) {
            orderFormLambdaCriteria.like(q -> {
                q.setCompanyName("%" + orderForm.getCompanyName() + "%");
            });
        }
        if (!Strings.isNullOrEmpty(orderForm.getPhone())) {
            orderFormLambdaCriteria.like(q -> {
                q.setPhone("%" + orderForm.getPhone() + "%");
            });
        }
        return orderFormLambdaCriteria;
    }

    @Override
    public void queryLike(OrderForm orderForm, Page<OrderForm> page) {
        LambdaCriteria<OrderForm> lambdaCriteria = getLambda(orderForm);
        List<OrderForm> list = lambdaCriteria.orderDesc("id").list(page.getPageCurrent(), page.getPageSize());
        Long count = lambdaCriteria.count();
        page.setList(list);
        page.setTotal(count);
    }

    public void checkOrder(OrderForm orderForm) {
        checkString(orderForm.getName(), "人员姓名不能为空");
        checkString(orderForm.getAddress(), "地址不能为空");
        checkString(orderForm.getCompanyName(), "公司名称不能为空");
        checkString(orderForm.getCount(), "数量不能为空");
        checkString(orderForm.getDeliveryTime(), "交付时间不能为空");
        checkString(orderForm.getGetOrSend(), "取送");
        checkString(orderForm.getMessage(), "备注");
        checkString(orderForm.getPageCount(), "页数");
        checkString(orderForm.getSize(), "规格");
        checkPhone(orderForm.getPhone(), "手机号码");
        checkString(orderForm.getTask(), "任务");
        checkString(orderForm.getTechnology(), "技术");
    }

    @Override
    public void insert(OrderForm orderForm) {
        checkOrder(orderForm);
        orderFormDao.save(orderForm);
    }

    @Override
    public void update(OrderForm orderForm) {
        checkOrder(orderForm);
        OrderForm orderFormInfo = orderFormDao.findFirstById(orderForm.getId());
        if (orderFormInfo != null) {
            orderFormInfo.setPhone(orderForm.getPhone());
            orderFormInfo.setCompanyName(orderForm.getCompanyName());
            orderFormInfo.setName(orderForm.getName());
            orderFormInfo.setAddress(orderForm.getAddress());
            orderFormInfo.setCount(orderForm.getCount());
            orderFormInfo.setDeliveryTime(orderForm.getDeliveryTime());
            orderFormInfo.setGetOrSend(orderForm.getGetOrSend());
            orderFormInfo.setMessage(orderForm.getMessage());
            orderFormInfo.setPageCount(orderForm.getPageCount());
            orderFormInfo.setSize(orderForm.getSize());
            orderFormInfo.setTask(orderForm.getTask());
            orderFormInfo.setTechnology(orderForm.getTechnology());
            orderFormDao.save(orderFormInfo);
        }
    }

    @Override
    public void delete(Long id) {
        orderFormDao.delete(id);
    }

    @Override
    protected JpaRepository<OrderForm, Long> getDao() {
        return orderFormDao;
    }
}
