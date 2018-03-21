package com.github.xuejike.springboot.jkfaststart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseJPA<T> extends JpaRepository<T,Long>,
        JpaSpecificationExecutor<T>,
        QueryDslPredicateExecutor<T> {



}
