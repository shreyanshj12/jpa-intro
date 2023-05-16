package com.sj.jpaintro.dao;

import com.sj.jpaintro.entity.Author;
import java.util.UUID;

public interface AuthorDao {
  Author getAuthorById(final UUID id);

  Author getAuthorByName(final String firstName, final String lastName);

  Author saveAuthor(final Author author);

  Author updateAuthor(final Author author);

  Integer deleteAuthor(final UUID authorId);
}
