package com.github.uwa9k073.pg_service.services;

import com.github.uwa9k073.pg_service.repositories.UserRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class HelloService  {
  private static final String helloFirstly = "Hello, %s!";
  private static final String helloSecondly = "Hello again, %s!";

  private final UserRepo repo;


  public String hello(String name) {
    log.info("START PROCESSING");
    var result = repo.executeHello(name);

    if (result == 1) {
      log.info(String.format(helloFirstly, name));
      return String.format(helloFirstly, name);
    }
    log.info(String.format(helloSecondly, name));

    return String.format(helloSecondly, name);
  }
}
