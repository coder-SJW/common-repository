package com.example.ignite2;

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
public class Ignite2Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Ignite2Application.class, args);
        Ignite ignite = run.getBean(Ignite.class);

        CacheConfiguration<String, String> cacheCfg = new CacheConfiguration<String, String>();
        cacheCfg.setBackups(1);
        cacheCfg.setCacheMode(CacheMode.PARTITIONED);
        cacheCfg.setName("main");
        //cacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);

        IgniteCache<String, String> cache = ignite.getOrCreateCache(cacheCfg);
        cache.put("1","2");
//        Lock lock = cache.lock("resendLock");
//        boolean b = lock.tryLock();
//        if (b){
//            System.out.println("获取锁成功===================");
//        }else {
//            System.out.println("获取锁失败=======================");
//        }

      //  lock.unlock();

        System.out.println(cache.get("1"));

    }

}
