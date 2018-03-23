package com.github.xuejike.springboot.print.service.impl;

import com.bidanet.bdcms.core.exception.CheckException;
import com.github.xuejike.springboot.jkfaststart.common.LambdaQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.regex.Pattern;

public abstract class BaseServiceImpl<T> {
    @Autowired
    LambdaQuery lambdaQuery;

    protected abstract JpaRepository<T, Long> getDao();

    public T findOne(Long id) {
        return this.getDao().findOne(id);
    }

    protected void errorMsg(String msg) {
        throw new CheckException(msg);
    }

    protected void checkNull(Object obj, String msg) {
        if (obj == null) {
            throw new CheckException(msg);
        }
    }


    public void update(Long id, Object updateObj) {
        T one = getDao().findOne(id);
        BeanUtils.copyProperties(updateObj, one);
        getDao().save(one);
    }

    protected void checkString(String str, String msg) {
        this.checkNull(str, msg);
        if (str.trim().isEmpty()) {
            throw new CheckException(msg);
        }
    }

    protected void checkPhone(String str, String msg) {
        this.checkNull(str, msg);
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        if (!p.matcher(str).matches()) {
            throw new CheckException(msg);
        }
    }
}
