package edu.ucsb.cs156.spring.backenddemo.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.ucsb.cs156.spring.backenddemo.services.EarthquakeQueryService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Slf4j
@RestController
@RequestMapping("/api/earthquakes")
public class EarthquakesController {
    
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    EarthquakeQueryService earthquakeQueryService;

    @GetMapping("/get")
    public ResponseEntity<String> getEarthquakes(
        @RequestParam String distance,
        @RequestParam String minMag
    ) throws JsonProcessingException {
        log.info("getEarthquakes: distance={} minMag={}", distance, minMag);
        String result = earthquakeQueryService.getJSON(distance, minMag);
        return ResponseEntity.ok().body(result);
    }

}
