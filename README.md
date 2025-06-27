# 🧪 Spring Boot Mock Toggle with Jetty as server

This is a Spring Boot **3.5.3** application (Java 21) that supports switching between **real external REST services** and **mocked responses** using **WireMock** — controlled via a simple property.

## ✅ Features

- Java 21, Spring Boot 3.5.3
- Toggle Real vs Mock mode vs Record mode with `mock.mode=NO/MOCK/RECORD`
- Mocked endpoints served via embedded WireMock
- Externalized request/response files (`__wiremock__/mappings`, `__wiremock__/files__`)
- Docker-ready for consistent test environments

---

## 🔧 Project Structure

http://localhost:8080/api/objects/1
