package com.github.uwa9k073.pg_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class ConfTest {

  @Bean
  @ServiceConnection
  PostgreSQLContainer<?> postgresContainer(DynamicPropertyRegistry registry) {
    var container = new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest")).withDatabaseName(
        "pg_service_db").withUsername("postgres").withPassword("postgres");
    registry.add("spring.datasource.driver-class-name", container::getDriverClassName);
    return container;
  }

  public static void main(String[] args) {
    SpringApplication.from(PgServiceApplication::main).with(ConfTest.class)
        .run(args);
  }

}
