package com.sj.jpaintro.dao;

import com.sj.jpaintro.entity.Author;
import java.util.UUID;

public interface AuthorDaoJdbcTemplate {
  Author getAuthorById(final UUID id);

  Author getAuthorByName(String firstName, String lastName);
  Author saveAuthor(final Author author);

  void updateAuthor(final Author saved);

  Integer deleteAuthorById(final UUID id);
}
