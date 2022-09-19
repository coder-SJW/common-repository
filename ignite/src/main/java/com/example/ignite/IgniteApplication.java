package com.example.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.locks.Lock;

@SpringBootApplication
@ComponentScan(value = "com.example")
public class IgniteApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(IgniteApplication.class, args);
        Ignite ignite = run.getBean(Ignite.class);

        CacheConfiguration<String, String> cacheCfg = new CacheConfiguration<String, String>();
        cacheCfg.setBackups(1);
        cacheCfg.setCacheMode(CacheMode.PARTITIONED);
        cacheCfg.setName("myCache");
        cacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);

        //IgniteCache<String, String> cache = ignite.getOrCreateCache(cacheCfg);
        IgniteCache<Object, Object> cache = ignite.cache("lockCache");
        Lock resendLock = cache.lock("resendLock");
        boolean b = resendLock.tryLock();
        if (b){
            System.out.println("获取锁成功===================");
        }else {
            System.out.println("获取锁失败=======================");
        }
       // resendLock.unlock();
        System.out.println("");
    }

}
