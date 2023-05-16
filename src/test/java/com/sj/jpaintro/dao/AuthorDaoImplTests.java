package com.sj.jpaintro.dao;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import com.sj.jpaintro.entity.Author;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorDaoImplTests {
  // integration tests for Dao pattern using Hibernate

  @Autowired
  private AuthorDao authorDao;

  @Test
  public void test_getAuthorById() {
    final UUID authorId = UUID.fromString("6bfd62bd-03ae-46db-a9e8-c6441ac67299");
    final Author retrievedAuthor = authorDao.getAuthorById(authorId);
    assertThat(retrievedAuthor).isNotNull();
    assertThat(retrievedAuthor.getFirstName()).isEqualTo("J");
  }

  @Test
  public void test_getAuthorByName() {
    final String firstName = "Robert";
    final String lastName = "Martin";
    final Author retrievedAuthor = authorDao.getAuthorByName(firstName, lastName);
    assertThat(retrievedAuthor).isNotNull();
  }

  @Test
  public void test_saveAuthor() {
    final Author author = Author.builder()
            .firstName("Franz")
            .lastName("Kafka")
            .build();

    final Author savedAuthor = authorDao.saveAuthor(author);
    assertThat(savedAuthor.getId()).isNotNull();
  }

  @Test
  public void test_updateAuthor() {
    final Author author = Author.builder()
            .firstName("Franz")
            .lastName("Kafka")
            .build();

    final Author savedAuthor = authorDao.saveAuthor(author);
    savedAuthor.setFirstName("William");
    savedAuthor.setLastName("Shakespeare");
    final Author updatedAuthor = authorDao.updateAuthor(savedAuthor);
    assertThat(updatedAuthor.getFirstName()).isEqualTo("William");
  }

  @Test
  public void test_deleteAuthor() {
    final UUID authorId = UUID.fromString("5ca79ade-1070-4489-b9cc-9f229df339cb");

    final Integer deleted = authorDao.deleteAuthor(authorId);
    assertThat(deleted).isEqualTo(1);
  }
}
