package com.tibell.ai.llm.ollama_edu.config;

import io.github.amithkoujalgi.ollama4j.core.OllamaAPI;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ConfigurationProperties(prefix = "ollama")
@Data
@Slf4j
public class OllamaConfig {
    @Value("${ollama.url}")
    private String url;

    @Value("${ollama.port}")
    private String port;

    @Value("${ollama.model}")
    private String model;

    @Bean
    public OllamaAPI ollamaAPI() {
        log.info("OllamaConfig created url: {}, port: {}, model: {}", url, port, model);
        String url = this.url + ":" + this.port;
        log.info("Ollama host: {}, model: {}",url, this.model);
        OllamaAPI ollamaAPI = new OllamaAPI(url);
        ollamaAPI.setVerbose(true);
        return ollamaAPI;
    }
}
