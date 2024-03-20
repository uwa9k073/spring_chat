package com.github.uwa9k073.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.CassandraContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class ConfTest {


  private static final String INIT_SCRIPT_PATH = "initial_script.cql";

  private static final DockerImageName cassandraImageName = DockerImageName.parse("cassandra:latest");
  private  static final DockerImageName scyllaImageName = DockerImageName.parse("scylladb/scylla:latest").asCompatibleSubstituteFor(cassandraImageName);

  @Bean
  @ServiceConnection
  CassandraContainer<?> cassandraContainer() {
    var container = new CassandraContainer<>(scyllaImageName).withInitScript(INIT_SCRIPT_PATH)
        .withExposedPorts(9042);
    container.start();
    System.setProperty("spring.cassandra.key-space", "chat");
    System.setProperty("spring.cassandra.contact-points",
        container.getContactPoint().getHostName());
    System.setProperty("spring.cassandra.local-datacenter", container.getLocalDatacenter());
    System.setProperty("spring.cassandra.port", container.getMappedPort(9042).toString());
    return container;
  }

  public static void main(String[] args) {
    SpringApplication.from(Application::main).with(ConfTest.class).run(args);
  }
}
