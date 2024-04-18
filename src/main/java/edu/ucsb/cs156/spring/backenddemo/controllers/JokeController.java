package edu.ucsb.cs156.spring.backenddemo.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.ucsb.cs156.spring.backenddemo.services.JokeQueryService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="joke-controller", description="Jokes from https://v2.jokeapi.dev/")
@Slf4j
@RestController
@RequestMapping("/api/jokes")
public class JokeController {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    JokeQueryService jokeQueryService;

    @Operation(summary="Get jokes for a given category and amount")
    @GetMapping("/get")
    public ResponseEntity<String> getJoke(
        @Parameter(name="amount", description="amount of jokes to get, e.g. '1' or '2'", example="amount - amount of jokes to get, e.g. '1' or '2'") @RequestParam String amount,
        @Parameter(name="category", description="category of joke, e.g. 'Programming' or 'Spooky'", example="category - category of joke, e.g. 'Programming' or 'Spooky'") @RequestParam String category
    ) throws JsonProcessingException {
        log.info("getJoke: category={} amount={}", category, amount);
        //turn amount into an integer
        int amountInt = Integer.parseInt(amount);
        String result = jokeQueryService.getJSON(category, amountInt);
        return ResponseEntity.ok().body(result);
    }

}