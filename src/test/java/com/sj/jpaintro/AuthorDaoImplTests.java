package com.sj.jpaintro;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import com.sj.jpaintro.dao.AuthorDao;
import com.sj.jpaintro.dao.AuthorDaoImpl;
import com.sj.jpaintro.entity.Author;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(AuthorDaoImpl.class)
@SpringBootTest
public class AuthorDaoImplTests {

  @Autowired
  AuthorDao authorDao;
  @Test
  public void testAuthorDao() {
    Author author = authorDao.getById(UUID.fromString("073760a6-341d-48ca-adb9-5259977f5c62"));
    assertThat(author).isNotNull();
  }
}
