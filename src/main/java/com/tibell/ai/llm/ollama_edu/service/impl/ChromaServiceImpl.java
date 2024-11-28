package com.tibell.ai.llm.ollama_edu.service.impl;

import com.tibell.ai.llm.ollama_edu.config.ChromeConfig;
import com.tibell.ai.llm.ollama_edu.service.MilvusService;
import io.milvus.v2.client.MilvusClientV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MilvusServiceImpl implements MilvusService {
    @Autowired
    private ChromeConfig config;

    @Autowired
    private MilvusClientV2 milvusClientV2;




}
