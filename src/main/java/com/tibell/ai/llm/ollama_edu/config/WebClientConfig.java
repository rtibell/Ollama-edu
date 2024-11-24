package com.tibell.ai.llm.ollama_edu.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
@Slf4j
public class WebClientConfig {
    @Value("${ollama.url}")
    private String ollamaUrl;

    @Value("${ollama.port}")
    private String ollamaPort;

    @Value("${ollama.model}")
    private String ollamaModel;

    @Bean
    public WebClient webClient() {
        String ollamaPath = ollamaUrl + ":" + ollamaPort + "/api";
        log.info("WebClient url: {}, model: {}", ollamaPath, ollamaModel);
        ConnectionProvider connectionProvider = ConnectionProvider.builder("custom")
                .maxConnections(500) // Increase the max connections
                .pendingAcquireMaxCount(2000) // Increase pending acquire queue size
                .pendingAcquireTimeout(Duration.ofSeconds(90)) // Wait time for acquiring a connection
                .build();

        HttpClient httpClient = HttpClient.create(connectionProvider)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 30000)
                .doOnConnected(conn -> conn
                        .addHandlerLast(new ReadTimeoutHandler(5, TimeUnit.SECONDS))
                        .addHandlerLast(new WriteTimeoutHandler(5, TimeUnit.SECONDS)));

        return WebClient.builder()
                .baseUrl(ollamaPath)
                .defaultHeader("Content-Type", "application/json")
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }
}

