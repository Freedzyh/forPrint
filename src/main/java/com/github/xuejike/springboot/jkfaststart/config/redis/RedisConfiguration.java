package com.github.xuejike.springboot.jkfaststart.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by yf003 on 2017/7/11.
 */
@Configuration
@EnableConfigurationProperties({JedisPoolConfigProperties.class,JedisPoolProperties.class})
public class RedisConfiguration {


    @Autowired
    JedisPoolConfigProperties jedisPoolConfigProperties;

    @Autowired
    JedisPoolProperties jedisPoolProperties;

    @Bean
    public JedisPool jedisPool(@Autowired JedisPoolConfig jedisPoolConfig) {

        return new JedisPool(jedisPoolConfig,
                jedisPoolProperties.getHost(),
                jedisPoolProperties.getPort(),
                jedisPoolProperties.getTimeout(),
                jedisPoolProperties.getPwd(),
                jedisPoolProperties.getDb());
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig (){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(jedisPoolConfigProperties.getMaxIdle());
        jedisPoolConfig.setMaxTotal(jedisPoolConfigProperties.getMaxTotal());
        jedisPoolConfig.setTestOnBorrow(jedisPoolConfigProperties.isTestOnBorrow());
        return jedisPoolConfig;
    }

}
