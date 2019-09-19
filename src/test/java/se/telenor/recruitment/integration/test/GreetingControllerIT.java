package se.telenor.recruitment.integration.test;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GreetingControllerIT {

    private String URL = "http://localhost:5000/greeting and verify the behavior";
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void verifyHiUserId123() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("account", "personal");
        headers.set("id", String.valueOf(123));
        HttpEntity httpEntity = new HttpEntity(headers);
        String response = restTemplate.exchange(URL, HttpMethod.GET, httpEntity, String.class).getBody();
        assertNotNull(response);
        assertEquals("Hi, userId 123", response);
    }

    @Test
    public void verifyWelcomeBusinessUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("account", "business");
        headers.set("type", "big");
        HttpEntity httpEntity = new HttpEntity(headers);
        String response = restTemplate.exchange(URL, HttpMethod.GET, httpEntity, String.class).getBody();
        assertNotNull(response);
        assertEquals("Welcome business user.", response);
    }
}
