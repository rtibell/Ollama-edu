package com.tibell.ai.llm.ollama_edu.service.impl;

import com.tibell.ai.llm.ollama_edu.repository.NewsFeedRepository;
import com.tibell.ai.llm.ollama_edu.repository.entity.NewsFeed;
import com.tibell.ai.llm.ollama_edu.service.NewsFeedService;
import com.tibell.ai.llm.ollama_edu.service.OllamaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class NewsFeedServiceImpl implements NewsFeedService {
    @Autowired
    private NewsFeedRepository newsFeedRepository;

    @Autowired
    private OllamaService ollamaService;

    public NewsFeedServiceImpl() {
        log.info("NewsFeedServiceImpl created");
    }

    @Override
    public List<NewsFeed> getAllNewsFeeds() {
        return newsFeedRepository.findAll();
    }

    @Override
    public NewsFeed getNewsFeedById(UUID id) {
        return newsFeedRepository.findById(id).orElse(null);
    }

    @Override
    public List<NewsFeed> pricessAllNewsFeeds() {
        List<NewsFeed> newsFeeds = getAllNewsFeeds();
        for (NewsFeed newsFeed : newsFeeds) {
            String description = newsFeed.getDescription();
            doSleep();
            List<Double> embeding = ollamaService.getEmbedding(description);
            if (embeding.size() > 0) log.info("{}, {}", description, embeding.get(0));
            //Mono<double[]> embeding = ollamaService.getEmbedding(description);
            //embeding.subscribe(data -> {
            //    log.info("Embedding for [" + description + "]: " + data);
            //});
        }
        return newsFeeds;
    }

    private void doSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
