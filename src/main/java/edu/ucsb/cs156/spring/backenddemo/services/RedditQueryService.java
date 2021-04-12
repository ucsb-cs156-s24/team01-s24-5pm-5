package edu.ucsb.cs156.spring.backenddemo.services;

import org.springframework.web.client.RestTemplate;


import org.springframework.boot.web.client.RestTemplateBuilder;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;


@Service
public class RedditQueryService {

    private final RestTemplate restTemplate;

    public RedditQueryService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public static final String ENDPOINT = "";

    public String getJSON(String subreddit) throws HttpClientErrorException {
        return "";
    }

   

}