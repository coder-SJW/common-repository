package com.example.esclient.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.Node;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author sjw
 * @Description
 * @Date 22:26 2022/9/25
 **/
@Configuration
public class ESConfig {
    @Bean
    public RestHighLevelClient getEsClient() {
        // 集群节点
        HttpHost http = new HttpHost("127.0.0.1", 9200, "http");

        // http客户端构造器
        RestClientBuilder builder = RestClient.builder(http);
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);
        return restHighLevelClient;
    }

}
