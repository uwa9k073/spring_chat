package com.github.uwa9k073.pg_service.controllers;

import com.github.uwa9k073.pg_service.exceptions.ResourceNotFound;
import com.github.uwa9k073.pg_service.services.HelloService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


@RestController
@AllArgsConstructor
@Slf4j
public class HelloController {

  private final HelloService service;


  @GetMapping("/v1/hello")
  public String controlHello(@RequestParam String name) {
    log.info(String.format("REQUEST: %s", name));

    var result = service.hello(name);

    log.info(String.format("RESPONSE: %s", result));

    return result;
  }
}
