package com.github.xuejike.springboot.print.dao;

import com.github.xuejike.springboot.jkfaststart.repository.BaseJPA;
import com.github.xuejike.springboot.print.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by xuemingyu 2018/3/21
 */
public interface SupplierDao extends JpaRepository<Supplier, Long> {
    Supplier findFirstById(Long id);

    Supplier findFirstByName(String name);

    Supplier findFirstByQq(String qq);

    Supplier findFirstByMobilePhone(String mobilePhone);

    Supplier findFirstByTelephone(String telephone);
}
