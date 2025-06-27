package com.example.mockdemo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@ConditionalOnProperty(name = "mock.mode", havingValue = "NO", matchIfMissing = true)
public class RealExternalClient implements ExternalClient {

    private final RestTemplate restTemplate;

    public RealExternalClient(RestTemplateBuilder builder, @Value("${external.service.url}") String baseUrl) {
        this.restTemplate = builder.rootUri(baseUrl).build();
    }

    @Override
    public String getUser(int id) {
        return restTemplate.getForObject( "/users/" + id, String.class);
    }

    @Override
    public String getOrder(int id) {
        return restTemplate.getForObject( "/orders/" + id, String.class);
    }
    @Override
    public String getObjects(int id) {
        return restTemplate.getForObject( "/objects/" + id, String.class);
    }
}