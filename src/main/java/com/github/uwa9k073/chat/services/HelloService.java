package com.github.uwa9k073.chat.services;

import com.github.uwa9k073.chat.entities.User;
import com.github.uwa9k073.chat.repos.UserRepo;
import com.github.uwa9k073.chat.exceptions.ResourceNotFound;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class HelloService {

  private final UserRepo repo;

  public void hello(String name) {
    log.info("User name: " + name);

    var user = repo.findByName(name);
    if (user.isEmpty()) {
      log.info("User not found");
      repo.saveUser(name);
      throw new ResourceNotFound(String.format("User with name: %s not found", name));
    }
  }
}
