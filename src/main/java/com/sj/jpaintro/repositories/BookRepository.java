package com.sj.jpaintro.repositories;

import com.sj.jpaintro.entity.Book;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, UUID> {

}
