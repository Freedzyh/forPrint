package com.github.xuejike.springboot.jkfaststart.repository;

import com.github.xuejike.springboot.jkfaststart.domain.AdminUser;

public interface AdminUserRepository extends BaseJPA<AdminUser> {
    AdminUser findByUsername(String username);
}
