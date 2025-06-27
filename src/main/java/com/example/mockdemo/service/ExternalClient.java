package com.example.mockdemo.service;

public interface ExternalClient {
    String getUser(int id);
    String getOrder(int id);
    String getObjects(int id);
}