package com.sj.jpaintro;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import com.sj.jpaintro.dao.AuthorDao;
import com.sj.jpaintro.dao.AuthorDaoImpl;
import com.sj.jpaintro.entity.Author;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Log4j2
@Import(AuthorDaoImpl.class)
@SpringBootTest
public class AuthorDaoImplTests {

  @Autowired
  AuthorDao authorDao;
  @Test
  public void testAuthorDao() {
    Author author = authorDao.getAuthorById(UUID.fromString("073760a6-341d-48ca-adb9-5259977f5c62"));
    assertThat(author).isNotNull();
  }

  @Test
  public void testGetAuthorByName() {
    Author author = authorDao.getAuthorByName("Craig","Walls");
    assertThat(author).isNotNull();
  }

  @Test
  public void testSaveAuthor() {
    Author author = new Author();
    author.setFirstName("John");
    author.setLastName("Thompson");
    Author saved = authorDao.saveAuthor(author);
    assertThat(saved).isNotNull();
  }

  @Test
  public void testUpdateAuthor() {
    Author author = new Author();
    author.setFirstName("J");
    author.setLastName("W");
    Author saved = authorDao.saveAuthor(author);
    saved.setLastName("T");
    authorDao.updateAuthor(saved);
  }

  @Test
  public void testDeleteAuthor() {
    Author author = new Author();
    author.setId(UUID.fromString("480f1192-6d4e-4830-a094-61dee9430629"));
    Integer isAuthorDeleted = authorDao.deleteAuthorById(author.getAuthorId());
    assertThat(isAuthorDeleted).isGreaterThan(0);
  }
}
