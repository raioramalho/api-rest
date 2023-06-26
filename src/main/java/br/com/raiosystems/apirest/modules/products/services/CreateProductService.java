package br.com.raiosystems.apirest.modules.products.services;

import org.springframework.stereotype.Service;

import br.com.raiosystems.apirest.entities.Product;
import br.com.raiosystems.apirest.repositories.IRepository;

@Service
public class CreateProductService {
  private IRepository<Product> repository;

  public CreateProductService(IRepository<Product> repository) {
    this.repository = repository;
  }

  public Product execute(Product product) {
    // Validar se o produto existe
    Product findProduct = this.repository.findByName(product.getName());

    // Se Sim - retornar erro
    if (findProduct != null) {
      throw new Error("Produto já cadastrado!");
    }

    // Se não - retornar novo produto
    return this.repository.save(product);

  }
}
