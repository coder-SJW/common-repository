package com.example.java.threadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author sjw
 * @Description ThreadLocal解决线程安全问题
 * @Date 21:54 2022/10/3
 **/
public class ThreadLocalService {
    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    /**
     * 业务方法：
     *  threadLocal的set方法
     *  public void set(T value) {
     *          // 获取当前线程的ThreadLocalMap
     *         Thread t = Thread.currentThread();
     *         ThreadLocalMap map = getMap(t);
     *         // 为线程设置ThreadLocalMap
     *         if (map != null) {
     *             map.set(this, value);
     *         } else {
     *             createMap(t, value);
     *         }
     *     }
     */
    public void doSomething(){
        threadLocal.set(new HashMap<String, Object>());
        Map<String, Object> data = threadLocal.get();
        // 用完记得remove，不然可能造成内存泄漏
        threadLocal.remove();
    }
}
