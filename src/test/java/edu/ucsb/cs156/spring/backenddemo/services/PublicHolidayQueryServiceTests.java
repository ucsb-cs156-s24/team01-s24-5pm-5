package edu.ucsb.cs156.spring.backenddemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.header;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;

@RestClientTest(PublicHolidayQueryService.class)
public class PublicHolidayQueryServiceTests {
    
    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Autowired
    private PublicHolidayQueryService publicholidayQueryService;

    @Test
    public void test_getJSON() {

        String year = "2000";
        String countryCode = "UK";
        String expectedURL = PublicHolidayQueryService.ENDPOINT.replace("{year}", year).replace("{countryCode}", countryCode);

        String fakeJsonResult = "{ \"fake\" : \"result\" }";

        this.mockRestServiceServer.expect(requestTo(expectedURL))
                .andExpect(header("Accept", MediaType.APPLICATION_JSON.toString()))
                .andExpect(header("Content-Type", MediaType.APPLICATION_JSON.toString()))
                .andRespond(withSuccess(fakeJsonResult, MediaType.APPLICATION_JSON));

        String actualResult = publicholidayQueryService.getJSON(year, countryCode);
        assertEquals(fakeJsonResult, actualResult);
    }
}