package com.github.uwa9k073.chat.entities;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table(value = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
  private UUID id;

  @Column(value = "name")
  private String name;

  public User(String name){
    this.id = UUID.randomUUID();
    this.name = name;
  }
}
