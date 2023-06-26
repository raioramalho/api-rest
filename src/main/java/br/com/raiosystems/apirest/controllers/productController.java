package br.com.raiosystems.apirest.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.raiosystems.apirest.entities.Product;
import br.com.raiosystems.apirest.modules.products.services.CreateProductService;
import br.com.raiosystems.apirest.modules.products.services.GetAllProductService;
import br.com.raiosystems.apirest.modules.products.services.GetProductService;
import br.com.raiosystems.apirest.repositories.IRepository;
import br.com.raiosystems.apirest.repositories.Repository;
import br.com.raiosystems.apirest.repositories.RepositoryTest;

@RestController
@RequestMapping("/products")
public class ProductController {

  IRepository<Product> repository = new RepositoryTest<Product>();
  // IRepository<Product> repository = new Repository<Product>("product");
  private CreateProductService createProductService = new CreateProductService(repository);
  private GetAllProductService getAllProductService = new GetAllProductService(repository);
  private GetProductService getProductService = new GetProductService(repository);

  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    Product response = this.createProductService.execute(product);
    return response;
  }

  @GetMapping
  public List<Product> listProducts() {
    List<Product> response = this.getAllProductService.execute();
    return response;
  }

  @GetMapping("/")
  public Product getProduct(@RequestParam UUID id) {
    Product response = this.getProductService.execute(id);
    return response;
  }

}
