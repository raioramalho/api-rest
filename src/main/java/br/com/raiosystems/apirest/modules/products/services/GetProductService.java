package br.com.raiosystems.apirest.modules.products.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.raiosystems.apirest.entities.Product;
import br.com.raiosystems.apirest.repositories.IRepository;

@Service
public class GetProductService {

  private IRepository<Product> repository;

  public GetProductService(IRepository<Product> repository) {
    this.repository = repository;
  }

  public Product execute(UUID id) {
    Product product = this.repository.findById(id);

    if (product == null) {
      throw new Error("Produto não encontrado!");
    }

    return product;
  }

}
