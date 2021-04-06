package edu.ucsb.cs156.spring.backenddemo.services;

import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;


@Slf4j
@Service
public class EarthquakeQueryService {

    ObjectMapper mapper = new ObjectMapper();

    public String getJSON(String distance, String minmag) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        String uri = "https://earthquake.usgs.gov/fdsnws/event/1/query";
        double ucsbLat = 34.4140; // hard coded params for Storke Tower
        double ucsbLong = -119.8489;
        String params = String.format("?format=geojson&minmagnitude=%s&maxradiuskm=%s&latitude=%f&longitude=%f", minmag,
                distance, ucsbLat, ucsbLong);

        String url = uri + params;
        log.info("url=" + url);

        String retVal = "";
        try {
            ResponseEntity<String> re = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            MediaType contentType = re.getHeaders().getContentType();
            HttpStatus statusCode = re.getStatusCode();
            retVal = re.getBody();
            log.info("contentType: {} statusCode: {}", contentType, statusCode);
        } catch (HttpClientErrorException e) {

            retVal = "{\"error\": }";
        }

        log.info("from EarthquakeQueryService.getJSON: {}", retVal);
        return retVal;
    }

}