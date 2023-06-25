package br.com.raiosystems.apirest.modules.products.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.raiosystems.apirest.entities.Product;
import br.com.raiosystems.apirest.repositories.ProductRepositoryTest;

@Service
public class GetProductService {

  private ProductRepositoryTest repository = new ProductRepositoryTest();

  public GetProductService(ProductRepositoryTest repository) {
    this.repository = repository;
  }

  public Product execute(UUID id) {
    Product product = this.repository.findById(id);
    return product;
  }

}
