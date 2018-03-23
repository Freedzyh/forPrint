package com.github.xuejike.springboot.print.dao;

import com.github.xuejike.springboot.jkfaststart.repository.BaseJPA;
import com.github.xuejike.springboot.print.entity.Process;

import java.util.List;

/**
 * Created by xuemingyu 2018/3/22
 */
public interface ProcessDao extends BaseJPA<Process> {
    Process findFirstById(Long id);

    Process findFirstByPid(Long pid);

    Process findFirstByName(String name);

}
