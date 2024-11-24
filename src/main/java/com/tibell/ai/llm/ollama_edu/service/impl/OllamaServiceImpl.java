package com.tibell.ai.llm.ollama_edu.service.impl;

import com.tibell.ai.llm.ollama_edu.config.OllamaConfig;
import com.tibell.ai.llm.ollama_edu.service.OllamaService;
import io.github.amithkoujalgi.ollama4j.core.OllamaAPI;
import io.github.amithkoujalgi.ollama4j.core.exceptions.OllamaBaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OllamaServiceImpl implements OllamaService {

    @Autowired
    OllamaAPI ollamaAPI;

    @Autowired
    OllamaConfig ollamaConfig;


//    @Autowired
//    private WebClient webClient;

//    @Autowired
//    public OllamaServiceImpl(OllamaConfig ollamaConfig) {
//        log.info("OllamaServiceImpl created url: {}, port: {}, model: {}", ollamaConfig.getUrl(), ollamaConfig.getPort(), ollamaConfig.getModel());
//        ollamaAPI = ollamaConfig.ollamaAPI();
//    }

    @Override
    public List<Double> getEmbedding(String inputText) {
        try {
            return ollamaAPI.generateEmbeddings(ollamaConfig.getModel(), inputText);
        } catch (IOException e) {
            log.warn("Error IOException: {}", e);
        } catch (InterruptedException e) {
            log.warn("Error InterruptedException: {}", e);
        } catch (OllamaBaseException e) {
            log.warn("Error OllamaBaseException: {}", e);
        }
        return new ArrayList<Double>();
    }

//    public Mono<double[]> getEmbedding(String inputText) {
//        return webClient.post()
//                .uri("/embed")
//                .bodyValue(new EmbedRequest(ollamaModel, inputText))
//                .retrieve()
//                .bodyToMono(EmbedResponse.class)
//                .map(EmbedResponse::getEmbedding)
//                .onErrorResume(WebClientResponseException.class, e -> {
//                    log.error("Error: " + e.getMessage());
//                    return Mono.empty();
//                });
//    }
//
//    public static class EmbedRequest {
//        private String model;
//        private String text;
//
//        public EmbedRequest(String model, String text) {
//            this.model = model;
//            this.text = text;
//        }
//
//        public String getModel() {
//            return model;
//        }
//
//        public void setModel(String model) {
//            this.model = model;
//        }
//
//        public String getText() {
//            return text;
//        }
//
//        public void setText(String text) {
//            this.text = text;
//        }
//    }
//
//    public static class EmbedResponse {
//        private double[] embedding;
//
//        public double[] getEmbedding() {
//            return embedding;
//        }
//
//        public void setEmbedding(double[] embedding) {
//            this.embedding = embedding;
//        }
//    }
}
