package br.com.raiosystems.apirest.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.raiosystems.apirest.entities.Product;
import br.com.raiosystems.apirest.modules.products.services.CreateProductService;
import br.com.raiosystems.apirest.repositories.ProductRepositoryTest;

@RestController
@RequestMapping("/products")
public class ProductController {

  ProductRepositoryTest repository = new ProductRepositoryTest();
  private CreateProductService createProductService = new CreateProductService(repository);

  @PostMapping
  public Product createProduct(@RequestBody Product product) {
    Product response = this.createProductService.execute(product);
    return response;
  }

}
