package com.example.config;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Author sjw
 * @Description
 * @Date 21:54 2022/9/17
 **/
@Configuration
public class IgniteConfig {
    @Bean
    public Ignite init1() {
        TcpDiscoverySpi spi = new TcpDiscoverySpi();
        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
        // 使用广播地址
        ipFinder.setMulticastGroup("228.10.10.157");
//        TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder();
//        ipFinder.setAddresses(Arrays.asList("127.0.0.1"));
        spi.setIpFinder(ipFinder);
        IgniteConfiguration cfg = new IgniteConfiguration();
        cfg.setDiscoverySpi(spi);
        return Ignition.start(cfg);
    }
}
