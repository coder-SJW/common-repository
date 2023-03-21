package com.example.example;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author sjw
 * @Description
 * @Date 22:51 2023/3/5
 **/
public class MomeryMeter {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        long l = GraphLayout.parseInstance(list).totalSize();
        System.out.println("jol: "+ l);
        try {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;

            oos = new ObjectOutputStream(bos);
            oos.writeObject(list);
            oos.flush();
            byte[] bytes = bos.toByteArray();
            System.out.println("比特流: "+ bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
