package com.github.uwa9k073.chat.repos;

import com.github.uwa9k073.chat.entities.User;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo  extends CassandraRepository<User, UUID> {

//  @Query("SELECT id, name FROM chat.users WHERE name = ? ALLOW FILTERING")

  @Query(allowFiltering = true)
  Optional<User> findByName(String name);

  default void saveUser(String name){
    this.save(new User(name));
  }
}
