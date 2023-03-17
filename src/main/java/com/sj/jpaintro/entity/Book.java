package com.sj.jpaintro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String bookTitle;
  private String isbn;
  private String publisher;

  /**
   * no-args constructor always required for an entity.
   */
  public Book() {

  }

  /**
   * Constructor to initialize the Book object.

   * @param title - title of the book
   * @param isbnNumber - isbn number for the book
   * @param bookPublisher - publisher of the book
   */
  public Book(final String title, final String isbnNumber, final String bookPublisher) {
    this.bookTitle = title;
    this.isbn = isbnNumber;
    this.publisher = bookPublisher;
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
}
