package edu.ucsb.cs156.spring.backenddemo.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.ucsb.cs156.spring.backenddemo.services.CollegeSubredditQueryService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="College Subreddits from https://github.com/karlding/college-subreddits/")
@RestController
@RequestMapping("/api/collegesubreddits")
public class CollegeSubredditsController {
    
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    CollegeSubredditQueryService collegeSubredditQueryService;

    @ApiOperation(value = "Get a list of college subreddits")
    @GetMapping("/get")
    public ResponseEntity<String> getSubreddits() throws JsonProcessingException {
        String result = collegeSubredditQueryService.getJSON();
        return ResponseEntity.ok().body(result);
    }

}