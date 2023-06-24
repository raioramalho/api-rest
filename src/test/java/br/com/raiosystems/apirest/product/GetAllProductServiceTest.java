package br.com.raiosystems.apirest.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.raiosystems.apirest.entities.Product;
import br.com.raiosystems.apirest.modules.courses.services.GetAllCourseService;
import br.com.raiosystems.apirest.modules.products.services.CreateProductService;
import br.com.raiosystems.apirest.modules.products.services.GetAllProductService;
import br.com.raiosystems.apirest.repositories.ProductRepositoryTest;

@SpringBootTest
public class GetAllProductServiceTest {
  @Test
  public void should_be_able_to_list_all_products() {
    // Produtos (id, name, price)

    // Criar produtos
    Product product1 = new Product("Mx Keys Mini", 220.00);
    Product product2 = new Product("Mx Keys", 320.00);

    // Repositorio de Produtos
    ProductRepositoryTest repositoryTest = new ProductRepositoryTest();

    // Cadastrar produtos
    CreateProductService createProductService = new CreateProductService(repositoryTest);
    createProductService.execute(product1);
    createProductService.execute(product2);

    // Listar produtos
    GetAllProductService getAllCourseService = new GetAllProductService(repositoryTest);
    List<Product> products = getAllCourseService.execute();

    assertEquals(2, products.size());
  }


  @Test
  public void should_resolve_error_if_list_is_empty() {
    // Produtos (id, name, price)
    // Repositorio de produtos
    ProductRepositoryTest repositoryTest = new ProductRepositoryTest();

    // Listar produtos
    GetAllProductService getAllProductService = new GetAllProductService(repositoryTest);

    Error error = assertThrows(Error.class, () -> {
      // Criar o segundo curso
      getAllProductService.execute();
    });

    assertEquals("Nenhum produto encontrado!", error.getMessage());
  }
}
