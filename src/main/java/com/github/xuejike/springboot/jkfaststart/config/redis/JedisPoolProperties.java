package com.github.xuejike.springboot.jkfaststart.config.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yf003 on 2017/7/11.
 */
@ConfigurationProperties(prefix = "jedis.pool")
public class JedisPoolProperties {

    private String host;

    private int port;

    private int timeout;

    private String pwd;

    private int db;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getDb() {
        return db;
    }

    public void setDb(int db) {
        this.db = db;
    }
}
