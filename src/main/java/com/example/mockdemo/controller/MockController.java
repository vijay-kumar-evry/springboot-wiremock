package com.example.mockdemo.controller;

import com.example.mockdemo.service.ExternalClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MockController {

    private final ExternalClient client;

    public MockController(ExternalClient client) {
        this.client = client;
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id") int id) {
        return client.getUser(id);
    }

    @GetMapping("/orders/{id}")
    public String getOrder(@PathVariable("id") int id) {
        return client.getOrder(id);
    }

    @GetMapping("/objects/{id}")
    public String getObjects(@PathVariable("id") int id) {
        return client.getObjects(id);
    }
}