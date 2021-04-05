package edu.ucsb.cs156.spring.backenddemo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class HomeController {
    

    @GetMapping("/")
    public ResponseEntity<String> getHome() throws JsonProcessingException {
        String body = getHomePageObjectJSON();
        return ResponseEntity.ok().body(body);
    }
    
    public static String getHomePageObjectJSON() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("greeting","Greetings from Spring Boot");
        resultMap.put("/api/earthquakes/get?distance=100&minMag=1.0","Information about Earthquakes");
        return mapper.writeValueAsString(resultMap);
    }
}
