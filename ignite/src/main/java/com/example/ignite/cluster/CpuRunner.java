package com.example.ignite.cluster;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author sjw
 * @Description
 * @Date 22:36 2023/12/8
 **/
public class CpuRunner extends Thread{
    @Override
    public void run() {
        while (true) {
            long sum = 0;
            for (int i = 0; i < 100000000; i++) {
                sum += i;
            }
        }
    }
}
