package br.com.raiosystems.apirest.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.raiosystems.apirest.entities.Department;
import br.com.raiosystems.apirest.entities.Product;

@RestController
@RequestMapping("/products")
public class productController {

  @GetMapping
  public List<Product> getObjects() {
    Department d1 = new Department(1L, "Tech");
    Department d2 = new Department(2L, "Pet");

    Product p1 = new Product(1L, "Macbook Pro", 4500.00, d1);
    Product p2 = new Product(2L, "Macbook Air", 4100.00, d1);
    Product p3 = new Product(3L, "Pet House", 300.00, d2);

    List<Product> list = Arrays.asList(p1, p2, p3);

    return list;
  }
}
