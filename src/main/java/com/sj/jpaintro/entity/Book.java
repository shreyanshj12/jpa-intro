package com.sj.jpaintro.entity;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Book {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  private UUID id;
  private String bookTitle;
  private String isbn;
  private String publisher;
  private UUID authorId;

  public UUID getAuthorId() {
    return authorId;
  }

  public void setAuthorId(UUID authorId) {
    this.authorId = authorId;
  }

  /**
   * no-args constructor always required for an entity.
   */
  public Book() {

  }

  /**
   * Constructor to initialize the Book object.
   *
   * @param title         - title of the book
   * @param isbnNumber    - isbn number for the book
   * @param bookPublisher - publisher of the book
   */
  public Book(final String title, final String isbnNumber, final String bookPublisher) {
    this.bookTitle = title;
    this.isbn = isbnNumber;
    this.publisher = bookPublisher;
  }

  public UUID getBookId() {
    return this.id;
  }

  /**
   * Set the title of the book.
   *
   * @param title - name of the book
   */
  public void setBookTitle(final String title) {
    this.bookTitle = title;
  }

  public String getBookTitle() {
    return this.bookTitle;
  }

  public void setIsbn(final String isbnNumber) {
    this.isbn = isbnNumber;
  }

  public String getIsbn() {
    return this.isbn;
  }

  public void setPublisher(final String bookPublisher) {
    this.publisher = bookPublisher;
  }

  public String getPublisher() {
    return this.publisher;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Book book = (Book) o;

    return Objects.equals(id, book.id);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
