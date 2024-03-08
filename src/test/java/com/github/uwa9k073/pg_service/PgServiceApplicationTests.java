package com.github.uwa9k073.pg_service;

import com.github.uwa9k073.pg_service.controllers.HelloController;
import com.github.uwa9k073.pg_service.repositories.UserRepo;
import com.github.uwa9k073.pg_service.services.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(classes = ConfTest.class)
@Testcontainers
class PgServiceApplicationTests {

  private static String contextLoadsMessage = "%s component not found in context";

  @Autowired
  private HelloController controller;
  @Autowired
  private HelloService service;
  @Autowired
  private UserRepo repo;

  @Test
  void contextLoads() {
    Assertions.assertNotNull(controller, String.format(contextLoadsMessage, HelloController.class));
    Assertions.assertNotNull(service, String.format(contextLoadsMessage, HelloService.class));
    Assertions.assertNotNull(repo, String.format(contextLoadsMessage, UserRepo.class));
  }

}
