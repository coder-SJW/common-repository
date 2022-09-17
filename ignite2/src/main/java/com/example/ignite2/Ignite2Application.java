package com.example.ignite2;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.example")
public class Ignite2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Ignite2Application.class, args);
        Ignite ignite = run.getBean(Ignite.class);

        CacheConfiguration<Integer, String> cacheCfg = new CacheConfiguration<Integer, String>();
        cacheCfg.setBackups(1);
        cacheCfg.setCacheMode(CacheMode.PARTITIONED);
        cacheCfg.setName("myCache");

        IgniteCache<Integer, String> cache = ignite.getOrCreateCache(cacheCfg);

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

}
