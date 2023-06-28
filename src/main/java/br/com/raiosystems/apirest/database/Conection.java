package br.com.raiosystems.apirest.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conection {
  private final String url;
  private final String username;
  private final String password;

  public Conection() {
  this.url = "jdbc:postgresql://localhost/JAVA";
  this.username = "postgres";
  this.password = "thinklife";
  }

  public ResultSet executeQuery(String query) throws SQLException {
    Connection connection = null;
    java.sql.Statement statement = null;
    ResultSet resultSet = null;

    try {
      connection = DriverManager.getConnection(url, username, password);
      statement = connection.createStatement();
      resultSet = statement.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (resultSet != null) {
        resultSet.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connection != null) {
        connection.close();
      }
    }

    return resultSet;
  }

  // Exemplo de uso

  // try {
  // String query = "SELECT * FROM tabela";
  // ResultSet resultSet = connection.executeQuery(query);

  // while (resultSet.next()) {
  // // Processar os resultados
  // }

  // resultSet.close();
  // } catch (SQLException e) {
  // e.printStackTrace();
  // }

}
