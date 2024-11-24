package com.tibell.ai.llm.ollama_edu.service.impl;

import com.tibell.ai.llm.ollama_edu.config.MilvusConfig;
import com.tibell.ai.llm.ollama_edu.service.MilvusService;
import io.milvus.client.MilvusClient;
import io.milvus.v2.client.ConnectConfig;
import io.milvus.v2.client.MilvusClientV2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MilvusServiceImpl implements MilvusService {
    @Autowired
    private MilvusConfig config;

    @Autowired
    private MilvusClientV2 milvusClientV2;




}
