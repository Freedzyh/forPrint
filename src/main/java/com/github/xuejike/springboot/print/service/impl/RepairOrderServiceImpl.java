package com.github.xuejike.springboot.print.service.impl;

import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.hibernate.lambda.core.LambdaCriteria;
import com.github.xuejike.springboot.print.dao.RepairOrderDao;
import com.github.xuejike.springboot.print.entity.RepairOrder;
import com.github.xuejike.springboot.print.service.RepairOrderService;
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
public class RepairOrderServiceImpl extends BaseServiceImpl<RepairOrder> implements RepairOrderService {
    @Autowired
    private RepairOrderDao repairOrderDao;

    public LambdaCriteria getLambda(RepairOrder repairOrder) {
        LambdaCriteria<RepairOrder> lambdaCriteria = lambdaQuery.create(RepairOrder.class);
        if (!Strings.isNullOrEmpty(repairOrder.getMainName())) {
            lambdaCriteria.like(q -> {
                q.setMainName("%" + repairOrder.getMainName() + "%");
            });
        }
        return lambdaCriteria;
    }

    @Override
    public void queryLike(RepairOrder repairOrder, Page<RepairOrder> page) {
        LambdaCriteria<RepairOrder> lambdaCriteria = getLambda(repairOrder);
        List<RepairOrder> list = lambdaCriteria.orderDesc("id").list(page.getPageCurrent(), page.getPageSize());
        Long count = lambdaCriteria.count();
        page.setTotal(count);
        page.setList(list);
    }

    @Override
    public void insert(RepairOrder repairOrder) {
        checkRepair(repairOrder);
        repairOrderDao.save(repairOrder);
    }

    @Override
    public void update(RepairOrder repairOrder) {
        checkRepair(repairOrder);
        RepairOrder repairOrderInfo = repairOrderDao.findFirstById(repairOrder.getId());
        if (repairOrderInfo != null) {
            repairOrderInfo.setMainName(repairOrder.getMainName());
            repairOrderInfo.setAssistCount(repairOrder.getAssistCount());
            repairOrderInfo.setAssistFormat(repairOrder.getAssistFormat());
            repairOrderInfo.setAssistProcess(repairOrder.getAssistProcess());
            repairOrderInfo.setAssistSize(repairOrder.getAssistSize());
            repairOrderInfo.setAssistSource(repairOrder.getAssistSource());
            repairOrderInfo.setCabinet(repairOrder.getCabinet());
            repairOrderInfo.setCaptainSign(repairOrder.getCaptainSign());
            repairOrderInfo.setEstimateCount(repairOrder.getEstimateCount());
            repairOrderInfo.setMainCount(repairOrder.getMainCount());
            repairOrderInfo.setMainSource(repairOrder.getMainSource());
            repairOrderInfo.setOpenCount(repairOrder.getOpenCount());
            repairOrderInfo.setPaperSize(repairOrder.getPaperSize());
            repairOrderInfo.setPrintCount(repairOrder.getPrintCount());
            repairOrderInfo.setProductionProcess(repairOrder.getProductionProcess());
            repairOrderInfo.setProductionRequire(repairOrder.getProductionRequire());
            repairOrderInfo.setReceiverSign(repairOrder.getReceiverSign());
            repairOrderInfo.setReleaseCount(repairOrder.getReleaseCount());
            repairOrderDao.save(repairOrderInfo);
        }
    }

    public void checkRepair(RepairOrder repairOrder) {
        checkString(repairOrder.getAssistCount(), "");
        checkString(repairOrder.getAssistFormat(), "");
        checkString(repairOrder.getAssistProcess(), "");
        checkString(repairOrder.getAssistSize(), "");
        checkString(repairOrder.getAssistSource(), "");
        checkString(repairOrder.getCabinet(), "");
        checkString(repairOrder.getCaptainSign(), "");
        checkString(repairOrder.getEstimateCount(), "");
        checkString(repairOrder.getMainCount(), "");
        checkString(repairOrder.getMainName(), "");
        checkString(repairOrder.getMainSource(), "");
        checkString(repairOrder.getOpenCount(), "");
        checkString(repairOrder.getPaperSize(), "");
        checkString(repairOrder.getPrintCount(), "");
        checkString(repairOrder.getProductionProcess(), "");
        checkString(repairOrder.getProductionRequire(), "");
        checkString(repairOrder.getReceiverSign(), "");
        checkString(repairOrder.getReleaseCount(), "");
    }

    @Override
    public void delete(Long id) {
        repairOrderDao.delete(id);
    }

    @Override
    protected JpaRepository<RepairOrder, Long> getDao() {
        return repairOrderDao;
    }
}
