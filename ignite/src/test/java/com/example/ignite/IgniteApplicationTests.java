package com.example.ignite;

import org.apache.ignite.Ignite;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IgniteApplicationTests {
    @Autowired
    Ignite igniteNode1;

    @Autowired
    Ignite igniteNode2;

    @Test
    void contextLoads() {
        System.out.println(igniteNode1);
    }

}
