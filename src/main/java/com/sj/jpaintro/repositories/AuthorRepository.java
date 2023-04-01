package com.sj.jpaintro.repositories;

import com.sj.jpaintro.entity.Author;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, UUID> {

}
