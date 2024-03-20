package com.github.uwa9k073.chat;

import com.github.uwa9k073.chat.controllers.HelloController;
import com.github.uwa9k073.chat.repos.UserRepo;
import com.github.uwa9k073.chat.services.HelloService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = ConfTest.class)
final class ApplicationTest {

//  @LocalServerPort
//  Integer port;

//  @Autowired
//  MockMvc mockMvc;

//  @Autowired
//  UserRepo repo;
//
//  @Autowired
//  HelloService service;
//
//  @Autowired
//  HelloController controller;

  @Test
  void contextLoads() {
//    String contextLoadsMessage = "%s component not found in context";
//    assertNotNull(controller, String.format(contextLoadsMessage, HelloController.class));
//    assertNotNull(service, String.format(contextLoadsMessage, HelloService.class));
//    assertNotNull(repo, String.format(contextLoadsMessage, UserRepo.class));
  }
}
