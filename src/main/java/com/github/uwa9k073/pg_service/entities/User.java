package com.github.uwa9k073.pg_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

  @Id
  @Column(name = "name")
  private String name;

  @Column(name = "count")
  private int count;

}


