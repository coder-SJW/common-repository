package com.example.ignite.cluster;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteEvents;
import org.apache.ignite.events.DiscoveryEvent;
import org.apache.ignite.events.EventType;
import org.apache.ignite.lang.IgnitePredicate;

/**
 * @Author sjw
 * @Description
 * @Date 21:14 2023/12/8
 **/
public class EventListener implements Runnable{
    private Ignite ignite;
    EventListener(Ignite ignite) {
        this.ignite = ignite;
    }
    @Override
    public void run() {
            IgniteEvents events = ignite.events();

            IgnitePredicate<DiscoveryEvent> localListener = evt -> {

                switch (evt.type()) {
                    case EventType.EVT_NODE_JOINED:
                        System.out.println("join");
                        break;
                    case EventType.EVT_NODE_LEFT:
                        System.out.println("left");
                        break;
                    case EventType.EVT_NODE_FAILED:
                        System.out.println("failed");
                        break;
                }
                System.out.println(evt);
                return true; // Continue listening.
            };
            events.localListen(localListener, EventType.EVT_NODE_JOINED, EventType.EVT_NODE_LEFT, EventType.EVT_NODE_FAILED);
        }
}
