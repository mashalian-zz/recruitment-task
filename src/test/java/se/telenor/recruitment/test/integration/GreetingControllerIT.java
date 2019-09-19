package se.telenor.recruitment.test.integration;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GreetingControllerIT {

    private String URL = "http://localhost:5000/greeting";
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void verifyHiUserId123() {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("id", 123)
                .queryParam("account", "personal");
        String response = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), String.class).getBody();
        assertNotNull(response);
        assertEquals("Hi, userId 123", response);
    }

    @Test
    public void verifyWelcomeBusinessUser() {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(URL)
                .queryParam("type", "big")
                .queryParam("account", "business");
        String response = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), String.class).getBody();
        assertNotNull(response);
        assertEquals("Welcome business user.", response);
    }
}
