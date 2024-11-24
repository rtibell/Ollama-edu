//package com.tibell.ai.llm;
//
//
////import io.github.amithkoujalgi.ollama4j.core.OllamaAPI;
////import io.github.amithkoujalgi.ollama4j.core.exceptions.OllamaBaseException;
//
//import java.io.IOException;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        String host = "http://192.168.86.203:11434";
//        String model = "nomic-embed-text";
////
////        OllamaAPI ollamaAPI = new OllamaAPI(host);
////        ollamaAPI.setVerbose(true);
////        System.out.println("Ollama is alive: " + ollamaAPI.ping());
////
////        try {
////            List<Double> ans1 = ollamaAPI.generateEmbeddings(model, "Hello, World!");
////            List<Double> ans2 = ollamaAPI.generateEmbeddings(model, "Hello, To the whole World!");
////            for (Double d : ans1) {
////                System.out.println(d);
////            }
////        } catch (IOException e) {
////            throw new RuntimeException(e);
////        } catch (InterruptedException e) {
////            throw new RuntimeException(e);
////        } catch (OllamaBaseException e) {
////            throw new RuntimeException(e);
////        }
//
//    }
//}