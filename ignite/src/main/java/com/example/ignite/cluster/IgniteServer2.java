package com.example.ignite.cluster;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.events.EventType;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;

/**
 * @Author sjw
 * @Description
 * @Date 21:42 2023/12/8
 **/
public class IgniteServer2 {
    public static void main(String[] args) {
        TcpDiscoverySpi spi = new TcpDiscoverySpi();
        TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
        // 使用广播地址
        ipFinder.setMulticastGroup("228.10.10.157");
        spi.setIpFinder(ipFinder);
        IgniteConfiguration cfg = new IgniteConfiguration();
        cfg.setDiscoverySpi(spi);
        cfg.setIncludeEventTypes(EventType.EVT_NODE_JOINED, EventType.EVT_NODE_LEFT, EventType.EVT_NODE_FAILED);
        Ignite ignite = Ignition.start(cfg);
        // 集群事件监听
        EventListener eventListener = new EventListener(ignite);
        new Thread(eventListener).start();
        // 搞个oom
//        OomRunner oomRunner = new OomRunner();
//        oomRunner.start();

        // 模拟cpu彪高
        CpuRunner cpuRunner = new CpuRunner();
        cpuRunner.start();

    }
}
