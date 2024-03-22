package com.github.uwa9k073.chat.controllers;

import com.github.uwa9k073.chat.exceptions.ResourceNotFound;
import com.github.uwa9k073.chat.services.HelloService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@Slf4j
public class HelloController {

  private static final String helloFirstly = "Hello, %s!";
  private static final String helloSecondly = "Hello again, %s!";

  private final HelloService service;

  @GetMapping("/v1/hello")
  public String controlHello(@RequestParam String name) {
    try {
      service.hello(name);
      return String.format(helloSecondly, name);
    } catch (ResourceNotFound e) {
      log.warn(e.getMessage());
      return String.format(helloFirstly, name);
    }
  }
}
