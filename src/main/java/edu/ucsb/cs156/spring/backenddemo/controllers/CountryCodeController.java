package edu.ucsb.cs156.spring.backenddemo.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.ucsb.cs156.spring.backenddemo.services.CountryCodeQueryService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(description="Country Code info from https://restcountries.eu")
@Slf4j
@RestController
@RequestMapping("/api/countrycodes")
public class CountryCodeController {
    
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    CountryCodeQueryService countryCodeQueryService;

    @ApiOperation(value = "Get a list of CountryCodes")
    @GetMapping("/get")
    public ResponseEntity<String> getCountryCodes() throws JsonProcessingException {
        String result = countryCodeQueryService.getJSON();
        return ResponseEntity.ok().body(result);
    }

}