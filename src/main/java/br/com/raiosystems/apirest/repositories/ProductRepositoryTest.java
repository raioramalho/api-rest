package br.com.raiosystems.apirest.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.raiosystems.apirest.entities.Product;

@Repository
public class ProductRepositoryTest {
  private List<Product> products;

  public ProductRepositoryTest() {
    this.products = new ArrayList<Product>();
  }

  public List<Product> getAll() {
    return products;
  }

  public Product findByName(String name) {
    Optional<Product> findProduct = this.products.stream().filter(products -> products.getName().equals(name)).findFirst();
    return findProduct.orElse(null);
  }

  public Product save(Product product) {
    this.products.add(product);
    product.setId(UUID.randomUUID());
    return product;
  }
}
