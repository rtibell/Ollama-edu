package com.tibell.ai.llm.ollama_edu.service;

import com.tibell.ai.llm.ollama_edu.repository.entity.NewsFeed;

import java.util.List;
import java.util.UUID;

public interface NewsFeedService {

    public List<NewsFeed> getAllNewsFeeds();
    public NewsFeed getNewsFeedById(UUID id);
    public List<NewsFeed> pricessAllNewsFeeds();
}
