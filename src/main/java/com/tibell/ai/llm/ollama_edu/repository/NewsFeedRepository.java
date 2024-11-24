package com.tibell.ai.llm.ollama_edu.repository;

import com.tibell.ai.llm.ollama_edu.repository.entity.NewsFeed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NewsFeedRepository extends JpaRepository<NewsFeed, UUID> {

}
