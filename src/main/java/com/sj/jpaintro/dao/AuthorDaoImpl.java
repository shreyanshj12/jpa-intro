package com.sj.jpaintro.dao;

import com.sj.jpaintro.entity.Author;
import java.util.UUID;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;

@Component
public class AuthorDaoImpl implements AuthorDao {

  private final EntityManagerFactory emf;

  public AuthorDaoImpl(final EntityManagerFactory emf) {
    this.emf = emf;
  }


  /**
   * @param id
   * @return author
   */
  @Override
  public Author getAuthorById(final UUID id) {
    return getEntityManager().find(Author.class, id);
  }

  /**
   * @param firstName
   * @param lastName
   * @return author
   */
  @Override
  public Author getAuthorByName(final String firstName, final String lastName) {

    //When you write HQL (or JPQL) queries, you use the names of the types i.e. Entity name, not the tables
    //hence using table name as Author (not author) in query

    final TypedQuery<Author> query = getEntityManager().createQuery(
            "SELECT a FROM Author a "
            + "WHERE a.firstName = :first_name AND a.lastName = :last_name",
            Author.class
    );
    query.setParameter("first_name", firstName);
    query.setParameter("last_name", lastName);
    return query.getSingleResult();
  }

  /**
   * @param author
   * @return
   */
  @Override
  public Author saveAuthor(final Author author) {
    final EntityManager em = getEntityManager();
    em.getTransaction().begin();
    em.persist(author);
    em.flush();
    em.getTransaction().commit();
    return author;
  }

  /**
   * @param author
   * @return
   */
  @Override
  public Author updateAuthor(final Author author) {
    final EntityManager em = getEntityManager();
    em.getTransaction().begin();
    em.merge(author);
    em.flush();

//    if you don't do commit and use authorDao.getById(authorId) in your test_updateAuthor to get the updated author
//    and assert on the updated author name, the test will fail because when using getAuthorById, we are creating a
//    new connection to the Database and this new thread won't see the changed data until we commit it

    em.getTransaction().commit();
    return em.find(Author.class, author.getId());
  }

  /**
   * @param authorId
   * @return
   */
  @Override
  public Integer deleteAuthor(final UUID authorId) {
    final EntityManager em = getEntityManager();
    final Author authorToDelete = em.find(Author.class, authorId);
    em.getTransaction().begin();
    em.remove(authorToDelete);
    em.flush();
    em.getTransaction().commit();
    return 1;
  }

  private EntityManager getEntityManager() {
    return emf.createEntityManager();
  }
}
