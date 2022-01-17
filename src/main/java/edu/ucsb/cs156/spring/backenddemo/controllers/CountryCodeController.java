package edu.ucsb.cs156.spring.backenddemo.controllers;

import edu.ucsb.cs156.spring.backenddemo.services.CountryCodeQueryService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(description="Country Code info from https://public.opendatasoft.com/explore/dataset/countries-codes")
@Slf4j
@RestController
@RequestMapping("/api/countrycodes")
public class CountryCodeController {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    CountryCodeQueryService countryCodeQueryService;

    @ApiOperation(value="Get a country's ISO codes and more", notes="Country data uploaded to OpenDataSoft by the International Labour Organization")
    @GetMapping("/get")
    public ResponseEntity<String> getCountryCodes(
        @ApiParam("country, e.g. United States") @RequestParam String country
    ) throws JsonProcessingException {
        log.info("getCountryCodes: country={}", country);
        String result = countryCodeQueryService.getJSON(country);
        return ResponseEntity.ok().body(result);
    }

}