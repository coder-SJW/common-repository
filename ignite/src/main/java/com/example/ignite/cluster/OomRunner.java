package com.example.ignite.cluster;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author sjw
 * @Description
 * @Date 21:39 2023/12/8
 **/
public class OomRunner extends Thread{

    static class OOMObject{
    }

    @Override
    public void run() {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
