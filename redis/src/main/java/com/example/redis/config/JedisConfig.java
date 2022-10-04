package com.example.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;


/**
 * @Author sjw
 * @Description
 * @Date 12:37 2022/10/4
 **/
@Configuration
public class JedisConfig {
    @Bean
    public Jedis jedisCluster(){
        HostAndPort hostAndPort = new HostAndPort("127.0.0.1", 6379);
        //return new JedisCluster(hostAndPort);
        return new Jedis("127.0.0.1", 6379);
    }
}
