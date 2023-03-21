package com.example.everthing.e1;

/**
 * @Author sjw
 * @Description
 * @Date 22:40 2023/3/21
 **/
public interface DemoService {

    /**
     * 所有实现类都要实现的方法
     */
    void methodA();

    /**
     * 部分实现类应该拥有的方法
     */
    void methodB();

    /**
     * 所有实现类都要实现的方法,但实现都一样，看做是实现类共同的动作
     */
    void methodC();
}
