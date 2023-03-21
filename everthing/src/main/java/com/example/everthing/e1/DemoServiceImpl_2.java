package com.example.everthing.e1;

import org.springframework.stereotype.Service;

/**
 * @Author sjw
 * @Description
 * @Date 22:41 2023/3/21
 **/
@Service
public class DemoServiceImpl_2 extends AbstractDemoServiceImpl{

    private String param;


    public String getParam() {
        return param;
    }

    @Override
    public void methodA() {

    }
}
