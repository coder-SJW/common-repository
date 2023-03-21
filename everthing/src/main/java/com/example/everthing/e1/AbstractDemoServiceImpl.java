package com.example.everthing.e1;

/**
 * @Author sjw
 * @Description
 * @Date 22:41 2023/3/21
 **/
public abstract class AbstractDemoServiceImpl implements DemoService {

    @Override
    public void methodB() {

    }

    @Override
    public void methodC() {
        String param = getParam();
        // do something
    }

    // 如果需要用到实现类里的参数，可以在抽象类里定义对应参数的getter抽象方法，实现类具体实现。
    protected abstract String getParam();
}
