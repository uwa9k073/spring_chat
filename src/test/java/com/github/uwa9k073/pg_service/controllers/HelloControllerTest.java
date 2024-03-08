package com.github.uwa9k073.pg_service.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.github.uwa9k073.pg_service.ConfTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ConfTest.class)
@AutoConfigureMockMvc
@Testcontainers
public class HelloControllerTest {


  @Autowired
  ConfTest config;

  @LocalServerPort
  private Integer port;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void controlHello() throws Exception {
    mockMvc.perform(get("/v1/hello?name=a")).andExpectAll(
            status().isOk(),
            content().string("Hello, a!")
        );
    mockMvc.perform(get("/v1/hello?name=a")).andExpectAll(
        status().isOk(),
        content().string("Hello again, a!")
    );
  }
}