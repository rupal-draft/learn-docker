
# Docker Learning and Project Summary

## Topics Covered
- Introduction to Docker
- Docker installation and commands
- Building Docker images using Dockerfile and Maven plugin
- Managing multiple Docker containers using Docker Compose
- Dockerizing microservice architecture with Docker Compose

---

## Dockerfile Format for Maven Projects

```dockerfile
FROM maven:3-eclipse-temurin-23-alpine

WORKDIR /app

COPY .mvn/ .mvn

COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]
```

### Build Docker Image
Run the following command to build a Docker image:
```bash
docker build -t userId/image-name .
```

---

## Docker Compose Configuration

Example `docker-compose.yml` for managing multiple containers:
```yaml
version: "3.8"

services:
  product-db:
    image: postgres
    container_name: product-db
    environment:
      POSTGRES_DB: product-db
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: <your_password_here>
    volumes:
      - <your_local_path_here>:/var/lib/postgresql/data
    networks:
      - myNetwork

  product-service:
    image: <your_image_name_here>
    container_name: product-service
    ports:
      - "8080:8080"
    networks:
      - myNetwork
    depends_on:
      - product-db

volumes:
  product-db-data:

networks:
  myNetwork:
```

### Steps:
1. Update the `application.properties` file to match the database configurations defined in the `docker-compose.yml`.
2. Run the following command to start all services:
   ```bash
   docker-compose up
   ```

---

## Docker Hub Image

This project is a basic Product Service application to create and retrieve products.

### Pull Docker Image
The Docker image has been pushed to Docker Hub. Use the following command to pull the image:
```bash
docker pull rupaldraft/product-service:latest
```

### Prerequisite
Log in to Docker Hub using the command:
```bash
docker login
```

---

## Project Highlights
This project demonstrates:
- A simple Product Service microservice with a PostgreSQL database.
- Dockerizing the application with a `Dockerfile`.
- Managing services using Docker Compose.
