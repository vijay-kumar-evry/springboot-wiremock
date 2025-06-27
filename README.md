# 🧪 Spring Boot Mock Toggle Example

This is a Spring Boot **3.5.3** application (Java 21) that supports switching between **real external REST services** and **mocked responses** using **WireMock** — controlled via a simple property.

## ✅ Features

- Java 21, Spring Boot 3.5.3
- Toggle real vs mock mode with `mock.mode=true`
- Mocked endpoints served via embedded WireMock
- Externalized request/response files (`__wiremock__/mappings`, `__wiremock__/__files__`)
- Docker-ready for consistent test environments

---

## 🔧 Project Structure

http://localhost:8080/api/objects/1