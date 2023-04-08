package com.sj.jpaintro.dao;

import com.sj.jpaintro.entity.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import javax.sql.DataSource;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class AuthorDaoImpl implements AuthorDao {
  private final DataSource dataSource;

  public AuthorDaoImpl(DataSource source) {
    this.dataSource = source;
  }

  private Connection getConnection() throws SQLException {
    return dataSource.getConnection();
  }

  private void closeConnection(Connection connection) {
    if(connection==null) {
      return;
    }

    try {
      connection.close();
    } catch(SQLException ex) {
        log.error("Failed to close the database connection", ex);
    }
  }

  @Override
  public Author getAuthorById(UUID id) {

    Connection connection = null;
    try {
      connection = getConnection();
      String query = "SELECT * FROM author where id = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setObject(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if(resultSet.next()){
        Author author = getAuthorFromResultSet(resultSet);
        preparedStatement.close();
        resultSet.close();
        return author;
      }
    } catch (SQLException ex) {
      log.error("Error retrieving author", ex);
    } finally {
      if(connection!=null){
        closeConnection(connection);
      }
    }
    return null;
  }

  @Override
  public Author saveAuthor(final Author author) {
    Connection connection = null;
    try {
      connection = getConnection();
      //returning id of the object created in postgres database
      String query = "INSERT INTO author (first_name, last_name) VALUES (?, ?) RETURNING id";
      PreparedStatement ps = connection.prepareStatement(query);
      ps.setString(1, author.getFirstName());
      ps.setString(2, author.getLastName());
      ResultSet rs = ps.executeQuery();
      if(rs.next()) {
        UUID savedId = rs.getObject("id", UUID.class);
        ps.close();
        rs.close();
        return getAuthorById(savedId);
      }
    } catch (SQLException ex) {
      log.error("Failed to save author to the database", ex);
    } finally {
      if(connection!=null) {
        closeConnection(connection);
      }
    }
    return null;
  }

  @Override
  public void updateAuthor(Author author){
    Connection connection = null;
    try {
      connection = getConnection();
      String query = "UPDATE author set first_name=?, last_name=? where id=?";
      PreparedStatement ps = connection.prepareStatement(query);
      ps.setString(1, author.getFirstName());
      ps.setString(2, author.getLastName());
      ps.setObject(3,author.getAuthorId());
      Integer rows = ps.executeUpdate();
      if(rows>0 && rows!=null){
        log.info("Successfully updated");
      }
    } catch (SQLException ex) {
      log.error("Failed to update", ex);
    } finally {
      if(connection!=null)
      {
        closeConnection(connection);
      }
    }
  }

  @Override
  public Integer deleteAuthorById(UUID id) {
    Connection connection = null;
    try {
      connection = getConnection();
      String query = "DELETE from author where id = ?";
      PreparedStatement ps = connection.prepareStatement(query);
      ps.setObject(1,id);
      Integer result = ps.executeUpdate();
      ps.close();
      return result;
    } catch (SQLException ex) {
      log.error(String.format("Failed to delete author with id = %s", id));
    } finally {
      closeConnection(connection);
    }
    return null;
  }

  @Override
  public Author getAuthorByName(final String firstName, final String lastName){
    Connection connection = null;

    try {
      connection = getConnection();

      String query = "SELECT * FROM author where first_name = ? AND last_name = ? ";
      PreparedStatement ps = connection.prepareStatement(query);
      ps.setString(1, firstName);
      ps.setString(2, lastName);
      ResultSet rs = ps.executeQuery();

      if(rs.next()) {
        Author author = getAuthorFromResultSet(rs);
        ps.close();
        rs.close();
        return  author;
      }
    } catch (SQLException ex) {
      log.error("Failed to retrieve author by name", ex);
    } finally {
      if(connection!=null) {
        closeConnection(connection);
      }
    }
    return null;
  }

  private Author getAuthorFromResultSet(ResultSet rs) throws SQLException {
    Author author = new Author();
    author.setId(rs.getObject("id", UUID.class));
    author.setFirstName(rs.getString("first_name"));
    author.setLastName(rs.getString("last_name"));
    return author;
  }
}
