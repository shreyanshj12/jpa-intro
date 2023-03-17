package com.sj.jpaintro.repositories;

import com.sj.jpaintro.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
