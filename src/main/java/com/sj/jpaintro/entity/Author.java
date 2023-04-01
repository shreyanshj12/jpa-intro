package com.sj.jpaintro.entity;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Author {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(length = 36, updatable = false, nullable = false)
  private UUID id;

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
    return this.id;
  }
  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  //equals and hashcode
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Author author = (Author) o;

    return id.equals(author.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
