package com.example.common.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SessionService {

    private final RestTemplate restTemplate;

    public SessionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean isUserLoggedIn(String id) {
        String url = "http://localhost:8088/account/login" + id;
        try {
            Boolean loggedIn = restTemplate.getForObject(url, Boolean.class);
            return loggedIn != null && loggedIn;
        } catch (Exception e) {
            // 에러 처리
            return false;
        }
    }
}
