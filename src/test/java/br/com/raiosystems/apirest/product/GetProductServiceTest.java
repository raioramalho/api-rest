package br.com.raiosystems.apirest.product;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.raiosystems.apirest.entities.Product;
import br.com.raiosystems.apirest.modules.products.services.CreateProductService;
import br.com.raiosystems.apirest.modules.products.services.GetAllProductService;
import br.com.raiosystems.apirest.modules.products.services.GetProductService;
import br.com.raiosystems.apirest.repositories.ProductRepositoryTest;

public class GetProductServiceTest {

  @Test
  public void should_be_able_to_list_product_by_id() {
    // Produtos (id, name, price)

    // Criar produtos
    Product product = new Product("Mx Keys Mini", 220.00);

    // Repositorio de Produtos
    ProductRepositoryTest repositoryTest = new ProductRepositoryTest();

    // Cadastrar produtos
    CreateProductService createProductService = new CreateProductService(repositoryTest);
    Product createdProduct = createProductService.execute(product);

    // Buscar produtos
    GetProductService getCourseService = new GetProductService(repositoryTest);
    Product findProduct = getCourseService.execute(createdProduct.getId());

    assertEquals(createdProduct.getId(), findProduct.getId());

  }

}