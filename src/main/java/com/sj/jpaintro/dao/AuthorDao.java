package com.sj.jpaintro.dao;

import com.sj.jpaintro.entity.Author;
import java.util.UUID;

public interface AuthorDao {

  Author getAuthorById(UUID id);

  Author getAuthorByName(String firstName, String lastName);
  Author saveAuthor(Author author);

  void updateAuthor(Author saved);

  Integer deleteAuthorById(UUID id);
}
