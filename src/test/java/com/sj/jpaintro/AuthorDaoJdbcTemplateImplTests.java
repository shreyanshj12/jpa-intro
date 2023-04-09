package com.sj.jpaintro;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import com.sj.jpaintro.dao.AuthorDaoJdbcTemplate;
import com.sj.jpaintro.dao.AuthorDaoJdbcTemplateImpl;
import com.sj.jpaintro.entity.Author;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(AuthorDaoJdbcTemplateImpl.class)
@SpringBootTest
public class AuthorDaoJdbcTemplateImplTests {
  @Autowired
  AuthorDaoJdbcTemplate authorDaoJdbcTemplate;

  @Test
  public void testGetAuthorById() {
    //initial test, should fail as CRUD operations aren't implemented yet
    Author author = authorDaoJdbcTemplate.getAuthorById(UUID.fromString("6bfd62bd-03ae-46db-a9e8-c6441ac67299"));
    assertThat(author).isNotNull();
  }
}
