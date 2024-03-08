package com.github.uwa9k073.pg_service.repositories;

import com.github.uwa9k073.pg_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

  String statement = "INSERT INTO users(name, count) VALUES(?1, 1) ON CONFLICT (name) DO UPDATE SET count = users.count + 1 RETURNING users.count";

  @Query(value = statement, nativeQuery = true)
  int executeHello(String name);
}
