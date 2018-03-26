package com.github.xuejike.springboot.print.service.impl;

import com.bidanet.bdcms.core.vo.Page;
import com.bidanet.hibernate.lambda.core.LambdaCriteria;
import com.github.xuejike.springboot.print.dao.CompanyDao;
import com.github.xuejike.springboot.print.dao.UserDao;
import com.github.xuejike.springboot.print.driver.uc.impl.HomeUserUcImpl;
import com.github.xuejike.springboot.print.entity.Company;
import com.github.xuejike.springboot.print.entity.User;
import com.github.xuejike.springboot.print.service.CompanyService;
import com.github.xuejike.springboot.print.service.UserService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by xuemingyu 2018/3/26
 */
@Service
@Transactional
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements CompanyService {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private UserDao userDao;

    @Override
    public void queryLike(Company company, Page<Company> page) {
        LambdaCriteria<Company> companyLambdaCriteria = lambdaQuery.create(Company.class);
        if (!Strings.isNullOrEmpty(company.getName())) {
            companyLambdaCriteria.like(q -> {
                q.setName("%" + company.getName() + "%");
            });
        }
        List<Company> list = companyLambdaCriteria.orderDesc("id").list(page.getPageCurrent(), page.getPageSize());
        Long count = companyLambdaCriteria.count();
        page.setList(list);
        page.setTotal(count);
    }

    @Override
    public void insert(Company company) {
        checkString(company.getName(), "公司名称不能为空");
        companyDao.save(company);
        User user = new User();
        user.setUserName(company.getName() + "admin");
        //  user.setUserPassword("123456");
        user.setCompanyId(company.getId());
        user.setNickName(company.getName());
        userDao.save(user);
    }

    @Override
    public void update(Company company) {
        Company companyInfo = companyDao.findFirstById(company.getId());
        companyInfo.setName(company.getName());
        User user = userDao.findFirstByCompanyId(company.getId());
        user.setUserName(company.getName() + "admin");
        user.setNickName(company.getName());
        userDao.save(user);
        companyDao.save(companyInfo);
    }

    @Override
    public void delete(Long id) {
        User user = userDao.findFirstByCompanyId(id);
        userDao.delete(user.getId());
        companyDao.delete(id);
    }

    @Override
    protected JpaRepository<Company, Long> getDao() {
        return companyDao;
    }
}
