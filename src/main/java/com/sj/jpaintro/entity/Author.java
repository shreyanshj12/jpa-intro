package com.sj.jpaintro.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Author {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private UUID authorId;

  private String firstName;
  private String lastName;

  public Author() {

  }

  public Author(final String firstName, final String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
  public void setFirstName(final String name) {
    this.firstName = name;
  }

  public void setLastName(final String name) {
    this.lastName = name;
  }

  public UUID getAuthorId() {
    return this.authorId;
  }
  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }
}
