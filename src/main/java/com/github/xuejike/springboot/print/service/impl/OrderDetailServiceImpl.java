package com.github.xuejike.springboot.print.service.impl;

import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.hibernate.lambda.core.LambdaCriteria;
import com.github.xuejike.springboot.print.dao.OrderDetailDao;
import com.github.xuejike.springboot.print.entity.OrderDetail;
import com.github.xuejike.springboot.print.service.OrderDetailService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by xuemingyu 2018/3/28
 */
@Service
@Transactional
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail> implements OrderDetailService {
    @Autowired
    private OrderDetailDao orderDetailDao;

    public LambdaCriteria getLambda(OrderDetail orderDetail) {
        LambdaCriteria<OrderDetail> lambdaCriteria = lambdaQuery.create(OrderDetail.class);
        if (!Strings.isNullOrEmpty(orderDetail.getComponent())) {
            lambdaCriteria.like(q -> {
                q.setComponent("%" + orderDetail.getComponent() + "%");
            });
        }
        return lambdaCriteria;
    }


    @Override
    public void queryLike(OrderDetail orderDetail, Page<OrderDetail> page) {
        LambdaCriteria<OrderDetail> orderDetailLambdaCriteria = getLambda(orderDetail);
        List<OrderDetail> list = orderDetailLambdaCriteria.orderDesc("id").list(page.getPageCurrent(), page.getPageSize());
        Long count = orderDetailLambdaCriteria.count();
        page.setTotal(count);
        page.setList(list);
    }

    @Override
    public void insert(OrderDetail orderDetail) {
        checkNull(orderDetail.getOrderId(), "订单id不能为空");
        checkString(orderDetail.getComponent(), "部件不能为空");
        checkString(orderDetail.getAuxfunUnit(), "辅助单位不能为空");
        checkString(orderDetail.getAuxfunValue(), "辅助值不能为空");
        checkString(orderDetail.getProcessTechnology(), "加工工艺不能为空");
        checkString(orderDetail.getSize(), "规格不能为空");
        checkString(orderDetail.getType(), "材质型号不能为空");
        checkString(orderDetail.getUnit(), "单位不能为空");
        checkNull(orderDetail.getCount(), "数量不能为空");
        orderDetailDao.save(orderDetail);
    }

    @Override
    public void delete(Long id) {
        orderDetailDao.delete(id);
    }

    @Override
    public List<OrderDetail> findAllByOrderId(Long orderId) {
        List<OrderDetail> list = orderDetailDao.findAllByOrderId(orderId);
        return list;
    }

    @Override
    protected JpaRepository<OrderDetail, Long> getDao() {
        return orderDetailDao;
    }
}
