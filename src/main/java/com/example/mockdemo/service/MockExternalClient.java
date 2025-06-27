package com.example.mockdemo.service;

import com.github.tomakehurst.wiremock.WireMockServer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@ConditionalOnExpression("'${mock.mode}' == 'MOCK' or '${mock.mode}' == 'RECORD'")
public class MockExternalClient implements ExternalClient {

    private final WireMockServer mockServer;
    private final RestTemplate restTemplate;

    public MockExternalClient(WireMockServer mockServer, RestTemplateBuilder builder,
                               @Value("${mock.url}") String mockUrl) {
        this.mockServer = mockServer;
        this.restTemplate = builder.rootUri(mockUrl).build();

    }

    @Override
    public String getUser(int id) {
        return restTemplate.getForObject("/users/" + id, String.class);
    }

    @Override
    public String getOrder(int id) {
        return restTemplate.getForObject("/orders/" + id, String.class);
    }

    /**
     * Only this have recording enabled.
     * @param id
     * @return
     */
    @Override
    public String getObjects(int id) {
        return restTemplate.getForObject("/objects/" + id, String.class);
    }
}