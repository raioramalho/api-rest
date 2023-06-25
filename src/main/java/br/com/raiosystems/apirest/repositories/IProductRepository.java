package br.com.raiosystems.apirest.repositories;

import java.util.List;
import java.util.UUID;

import br.com.raiosystems.apirest.entities.Product;

public interface IProductRepository {
   public Product findByName(String name);

  public Product findById(UUID id);

  public List<Product> getAll();

  public Product save(Product product);

}
