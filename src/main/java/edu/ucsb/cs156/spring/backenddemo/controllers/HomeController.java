package edu.ucsb.cs156.spring.backenddemo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@RestController
public class HomeController {
    

    @GetMapping("/")
    public ResponseEntity<String> getHome() throws JsonProcessingException {

        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
        // builder.scheme("http");
        URI uri = builder.build().toUri();

        String body = getHomePageObjectJSON(uri.toString());
        return ResponseEntity.ok().body(body);
    }
    
    public static String getHomePageObjectJSON(String baseUrl) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("greeting","Greetings from Spring Boot");
        resultMap.put("api-documentation", baseUrl + "swagger-ui/");
        return mapper.writeValueAsString(resultMap);
    }
}
