package br.com.raiosystems.apirest.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import br.com.raiosystems.apirest.database.Conection;
import br.com.raiosystems.apirest.entities.Item;

public class Repository<T extends Item> implements IRepository<T> {

  private String model;

  public Repository(String model) {
    this.model = model;
  }

  public T findById(UUID id) {
    String query = "SELECT * FROM public.'" + this.model.toUpperCase() + "' WHERE id = '" + id + "'";
    return null;
  }

  public T findByName(String name) {
    String query = "SELECT * FROM public.'" + this.model.toUpperCase() + "' WHERE name = '" + name + "'";
    return null;
  }

  public List<T> getAll() {
    try {

      Conection con = new Conection();

      String query = "SELECT * FROM public.'" + this.model.toUpperCase() + "'";


      ResultSet resultSet = con.executeQuery(query);

      // while (resultSet.next()) {
      //   // Processar os resultados
      // }

      System.out.println(resultSet.toString());

      resultSet.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  public T save(T data) {
    String query = "INSERT INTO public.'" + this.model.toUpperCase() + "' VALUE ()";
    return null;
  }

}
