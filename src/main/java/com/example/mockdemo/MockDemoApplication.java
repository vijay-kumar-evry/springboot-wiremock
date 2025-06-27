package com.example.mockdemo;

import jakarta.annotation.PostConstruct;

import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.LogManager;

@SpringBootApplication
public class MockDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MockDemoApplication.class, args);
    }
    /**
     * Set the global log level for WireMock to DEBUG.
     * This is useful for debugging and seeing detailed logs of the mock server.
     */

    @PostConstruct
    public void initWireMockLoggingBridge() {
        System.setProperty("wiremock.globalLogLevel", "DEBUG");
        System.out.println("🔧 Installing JUL → SLF4J bridge for WireMock...");
        LogManager.getLogManager().reset();                      // Clear default JUL handlers
        SLF4JBridgeHandler.removeHandlersForRootLogger();        // Remove any existing
        SLF4JBridgeHandler.install();                            // Install bridge
    }
}