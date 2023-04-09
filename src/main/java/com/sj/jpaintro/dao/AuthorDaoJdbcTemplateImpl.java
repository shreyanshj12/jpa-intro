package com.sj.jpaintro.dao;

import com.sj.jpaintro.entity.Author;
import java.util.UUID;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component  //needed otherwise Autowire won't work in integ tests
public class AuthorDaoJdbcTemplateImpl implements AuthorDaoJdbcTemplate {
  @Override
  public Author getAuthorById(final UUID id) {
   return null;
  }

  @Override
  public Author getAuthorByName(final String firstName, final String lastName) {
    return null;
  }

  @Override
  public Author saveAuthor(final Author author) {
    return null;
  }

  @Override
  public void updateAuthor(final Author saved) {

  }

  @Override
  public Integer deleteAuthorById(final UUID id) {
    return null;
  }
}
