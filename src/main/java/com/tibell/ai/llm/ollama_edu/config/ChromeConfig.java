package com.tibell.ai.llm.ollama_edu.config;

import io.milvus.client.MilvusClient;
import io.milvus.param.ConnectParam;
import io.milvus.v2.client.ConnectConfig;
import io.milvus.v2.client.MilvusClientV2;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "milvus")
@Data
@Slf4j
public class MilvusConfig {
    @Value("${milvus.url}")
    private String url;

    @Value("${milvus.port}")
    private String port;

    @Bean
    public MilvusClientV2 milvusClientV2(MilvusConfig config) {
        log.info("MilvusConfig created url: {}, port: {}", url, port);
        log.info("MilvusServiceImpl creating");
        MilvusClientV2 client = new MilvusClientV2(ConnectConfig.builder()
                .uri(config.getUrl() + ":" + config.getPort())
                .build());
        log.info("Milvus client created for url: {}", config.getUrl() + " port:" + config.getPort());
        return client;
    }
}
