package com.sj.jpaintro.dao;

import com.sj.jpaintro.entity.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import javax.sql.DataSource;
import lombok.extern.log4j.Log4j2;
import org.postgresql.ds.PGSimpleDataSource;
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
  public Author getById(UUID id) {

    Connection connection = null;
    try {
      connection = getConnection();
      String query = "SELECT * FROM author where id = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(query);
      preparedStatement.setObject(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if(resultSet.next()){
        Author author = new Author();
        author.setId(resultSet.getObject("id", UUID.class));
        author.setFirstName(resultSet.getString("first_name"));
        author.setLastName(resultSet.getString("last_name"));
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
}
