package com.sj.jpaintro.bootstrap;

import com.sj.jpaintro.entity.Book;
import com.sj.jpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

  private final BookRepository bookRepository;

  public DataInitializer(final BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Book bookDdd = new Book("Domain Driven Design", "123", "RandomHousePublisher");
    Book savedDdd = bookRepository.save(bookDdd);

    Book bookSia = new Book("Spring in Action", "3434", "Orielly");
    Book savedSia = bookRepository.save(bookSia);

    bookRepository.findAll().forEach(book -> {
      System.out.println(book.getBookId());
    });
  }
}
