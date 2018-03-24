package com.github.xuejike.springboot.print.utils;

import java.util.List;

/**
 * Created by xuemingyu 2018/3/24
 */
public class TypeBean {
    private Long id;
    private Long pid;
    private String name;
    private List<TypeBean> list;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TypeBean> getList() {
        return list;
    }

    public void setList(List<TypeBean> list) {
        this.list = list;
    }

    public TypeBean(Long id, Long pid, String name, List<TypeBean> list) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.list = list;
    }

    public TypeBean() {
    }
}
