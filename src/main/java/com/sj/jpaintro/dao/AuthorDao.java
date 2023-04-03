package com.sj.jpaintro.dao;

import com.sj.jpaintro.entity.Author;
import java.util.UUID;

public interface AuthorDao {

  Author getById(UUID id);
}
