package com.example.ignite.lock;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;

/**
 * @Author sjw
 * @Description ignite实现分布式锁
 * @Date 1:12 2022/9/20
 **/
@Service
public class LockService {
    @Autowired
    Ignite ignite;

    public void doSomething(){
        Lock resendLock = null;
        try {
            IgniteCache<String, String> cache = ignite.getOrCreateCache(getLockCacheConfiguration());
            resendLock = cache.lock("resendLock");
            boolean b = resendLock.tryLock();
            if (b){
                // 获取到锁了
            }else {
                // 没获取到锁
            }
        } finally {
            resendLock.unlock();
        }
    }

    /**
     * 获取缓存配置信息
     * 如果用ignite做分布式锁最好单独起一个缓存配置，不要共用业务缓存配置
     * 因为ignite锁必须要设置缓存为原子模式（事务模式），可能相应的业务缓存则不需要事务，容易造成逻辑的混乱。
     * @return
     */
    public CacheConfiguration<String, String> getLockCacheConfiguration(){
        CacheConfiguration<String, String> cacheCfg = new CacheConfiguration<String, String>();
        cacheCfg.setBackups(1);
        // 集群模式
        cacheCfg.setCacheMode(CacheMode.PARTITIONED);
        cacheCfg.setName("lockCache");
        // 原子模式（锁只能在这种模式下实现）
        cacheCfg.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
        return cacheCfg;
    }
}
