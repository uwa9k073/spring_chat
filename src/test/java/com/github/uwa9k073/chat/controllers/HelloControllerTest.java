package com.github.uwa9k073.chat.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.github.uwa9k073.chat.ConfTest;
import com.github.uwa9k073.chat.entities.User;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = ConfTest.class)
@AutoConfigureMockMvc
class HelloControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  void TEST_HELLO_FIRST_TIME() throws Exception {
    mockMvc.perform(get("/v1/hello?name=a"))
        .andExpectAll(status().isOk(), content().string("Hello, a!"));
  }

  @Test
  void TEST_HELLO_SECOND_TIME() throws Exception {
    mockMvc.perform(get("/v1/hello?name=a"))
        .andExpectAll(status().isOk(), content().string("Hello again, a!"));
  }
}