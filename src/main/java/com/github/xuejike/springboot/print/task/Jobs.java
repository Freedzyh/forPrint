package com.github.xuejike.springboot.print.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by yf003 on 2017/8/22.
 */
@Component
public class Jobs {





//    @Scheduled(cron="0 0/1 * * * ?") //每分钟执行一次
    @Scheduled(cron="0 0 0 1 * ? *") //每个月1日执行一次
    public void cronMonthJob(){

    }
}
