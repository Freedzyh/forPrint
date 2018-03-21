package com.github.xuejike.springboot.jkfaststart.config.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yf003 on 2017/7/11.
 */
@ConfigurationProperties(prefix = "jedis.pool.config")
public class JedisPoolConfigProperties {

    private int maxIdle;

    private int maxTotal;

    private boolean testOnBorrow;


    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }
}
