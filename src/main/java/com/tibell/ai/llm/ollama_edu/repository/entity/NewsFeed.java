package com.tibell.ai.llm.ollama_edu.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "news_feed")
@Data
public class NewsFeed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String category;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    private String description;

    private String etag;

    private String etag2;

    private String link;

    @Column(name = "pub_date")
    private LocalDateTime pubDate;

    private String source;

    private String ticker;

    private String title;

    private String titleEx;


//    `id` binary(16) NOT NULL,
//  `category` varchar(255) DEFAULT NULL,
//  `creation_date` datetime(6) NOT NULL,
//  `description` varchar(8192) NOT NULL,
//  `etag` varchar(255) NOT NULL,
//  `etag2` varchar(255) NOT NULL,
//  `link` varchar(255) DEFAULT NULL,
//  `pub_date` datetime(6) DEFAULT NULL,
//  `source` varchar(255) DEFAULT NULL,
//  `ticker` varchar(255) DEFAULT NULL,
//  `title` varchar(255) NOT NULL,
//  `title_ex` varchar(255) DEFAULT NULL,
}
