package br.com.raiosystems.apirest.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conection {
  public static Connection execute() {
      Connection conn = null;
        try {
          conn = DriverManager.getConnection("jdbc:postgresql://localhost/JAVA", "postgres", "thinklife");
          System.out.println("Connected to the PostgreSQL server successfully.");
          return conn;
        } catch (SQLException e) {
          System.out.println(e.getMessage());
        }
        return conn;
  }
}
