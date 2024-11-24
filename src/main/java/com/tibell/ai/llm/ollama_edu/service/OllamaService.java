package com.tibell.ai.llm.ollama_edu.service;

import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface OllamaService {
    //public Mono<double[]> getEmbedding(String inputText);
    public List<Double> getEmbedding(String inputText);

}
