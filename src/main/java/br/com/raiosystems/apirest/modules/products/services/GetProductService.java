package br.com.raiosystems.apirest.modules.products.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.raiosystems.apirest.entities.Product;
import br.com.raiosystems.apirest.repositories.IProductRepository;

@Service
public class GetProductService {

  private IProductRepository repository;

  public GetProductService(IProductRepository repository) {
    this.repository = repository;
  }

  public Product execute(UUID id) {
    Product product = this.repository.findById(id);
    return product;
  }

}
