# Microservice-Projects

This repository contains projects and examples demonstrating microservice concepts using **Java Spring Boot**. Each project is designed to showcase a specific aspect of microservice architecture, such as service discovery, API gateways, distributed tracing, and more.

---

##  Features and Topics Covered
- **Service Discovery**: Implementing Eureka Server and Client for dynamic service registration and discovery.
- **API Gateway**: Using Spring Cloud Gateway for centralized routing and authentication.
- **Load Balancing**: Implementing client-side load balancing with Spring Cloud LoadBalancer.
- **Fault Tolerance**: Adding resilience with tools like Resilience4j.
- **Distributed Tracing**: Setting up tracing with Zipkin/Sleuth for tracking requests across services.
- **Database Interaction**: Using Spring Data JPA with PostgreSQL.
- **Inter-Service Communication**: REST and Feign client communication between services.
- **Authentication and Security**: Securing microservices with Spring Security and OAuth2 (e.g., Okta integration).
- **Dockerization**: Containerizing microservices using Docker.

---

## 🏗️ Projects

### 1. **Eureka Server and Client Setup**
- **Description**: A basic example of service discovery using Eureka.
- **Key Features**: Service registration, load balancing.
- **Path**: `projects/eureka-setup`

### 2. **API Gateway**
- **Description**: Demonstrates an API Gateway that routes requests to backend services and handles authentication.
- **Key Features**: Centralized routing, OAuth2 integration.
- **Path**: `projects/api-gateway`

### 3. **User and Rating Microservices**
- **Description**: Implements a user-service and rating-service demonstrating inter-service communication.
- **Key Features**: Feign clients, internal service calls.
- **Path**: `projects/user-rating`

### 4. **Distributed Tracing with Zipkin**
- **Description**: Tracks request flows across multiple microservices.
- **Key Features**: Spring Sleuth, Zipkin integration.
- **Path**: `projects/distributed-tracing`

---

## 🛠️ Tech Stack
- **Language**: Java
- **Framework**: Spring Boot, Spring Cloud
- **Database**: PostgreSQL
- **Build Tools**: Maven
- **Containerization**: Docker
- **Authentication**: OAuth2 (Okta)

---

## ⚡ Getting Started

### Prerequisites
- JDK 17+
- Maven
- Docker (optional)
- PostgreSQL (optional)

### Steps to Run a Project
1. Clone this repository:
   ```bash
   git clone https://github.com/jayitasaha40/Microservice-Projects.git
   cd Microservice-Projects
