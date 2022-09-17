package com.example.ignite;

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
public class IgniteApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(IgniteApplication.class, args);
        Ignite ignite = run.getBean(Ignite.class);

        CacheConfiguration<Integer, String> cacheCfg = new CacheConfiguration<Integer, String>();
        cacheCfg.setBackups(1);
        cacheCfg.setCacheMode(CacheMode.PARTITIONED);
        cacheCfg.setName("myCache");

        IgniteCache<Integer, String> cache = ignite.getOrCreateCache(cacheCfg);

        cache.put(1, "ignite1 from node1");
        cache.put(2, "ignite2 from node1");
        cache.put(3, "ignite3 from node1");
    }

}
