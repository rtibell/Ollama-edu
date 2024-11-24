package com.tibell.ai.llm.ollama_edu.api;

import com.tibell.ai.llm.ollama_edu.repository.entity.NewsFeed;
import com.tibell.ai.llm.ollama_edu.service.NewsFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/news")
public class LocalNewsController {
    @Autowired
    private NewsFeedService newsFeedService;

    @GetMapping
    public List<NewsFeed> getAllNewsFeeds() {
        return newsFeedService.getAllNewsFeeds();
    }

    @GetMapping("/{id}")
    public NewsFeed getNewsFeed(@PathVariable UUID id) {
        return newsFeedService.getNewsFeedById(id);
    }

    @GetMapping("/process")
    public List<NewsFeed> getProcessing() {
        return newsFeedService.pricessAllNewsFeeds();
    }

}
