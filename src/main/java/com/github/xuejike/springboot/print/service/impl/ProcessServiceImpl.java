package com.github.xuejike.springboot.print.service.impl;

import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.hibernate.lambda.core.LambdaCriteria;
import com.github.xuejike.springboot.print.dao.ProcessDao;
import com.github.xuejike.springboot.print.entity.Process;
import com.github.xuejike.springboot.print.service.ProcessService;
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
public class ProcessServiceImpl extends BaseServiceImpl<Process> implements ProcessService {
    @Autowired
    private ProcessDao processDao;

    public LambdaCriteria getLambda(Process process) {
        LambdaCriteria<Process> processLambdaCriteria = lambdaQuery.create(Process.class);
        if (!Strings.isNullOrEmpty(process.getName())) {
            processLambdaCriteria.like(q -> {
                q.setName("%" + process.getName() + "%");
            });
        }
        return processLambdaCriteria;
    }

    @Override
    public void queryLike(Process process, Page<Process> page) {
        LambdaCriteria<Process> lambdaCriteria = getLambda(process);
        List<Process> list = lambdaCriteria.orderDesc("id").list(page.getPageCurrent(), page.getPageSize());
        Long count = lambdaCriteria.count();
        page.setTotal(count);
        page.setList(list);
    }

    @Override
    public void insert(Process process) {
        checkString(process.getName(), "加工名称不能为空");
        processDao.save(process);
    }

    @Override
    public void update(Process process) {
        checkString(process.getName(), "加工名称不能为空");
        Process processInfo = processDao.findFirstById(process.getId());
        if (processInfo != null) {
            processInfo.setName(process.getName());
            processDao.save(processInfo);
        }
    }

    @Override
    public void delete(Long id) {
        processDao.delete(id);
    }

    @Override
    protected JpaRepository<Process, Long> getDao() {
        return processDao;
    }

    @Override
    public void addSubclass(Long id, Long pid, Process process) {
        if (pid == null) {
            process.setPid(0l);
            processDao.save(process);
        } else {
            process.setPid(id);
            processDao.save(process);
        }
    }

    @Override
    public List<Process> findAll() {

        return processDao.findAll();
    }
}
