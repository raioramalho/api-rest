package br.com.raiosystems.apirest.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import br.com.raiosystems.apirest.entities.Product;
import br.com.raiosystems.apirest.modules.products.services.CreateProductService;
import br.com.raiosystems.apirest.modules.products.services.GetProductService;
import br.com.raiosystems.apirest.repositories.IRepository;
import br.com.raiosystems.apirest.repositories.RepositoryTest;

public class GetProductServiceTest {

  @Test
  public void should_be_able_to_get_product_by_id() {
    // Produtos (id, name, price)

    // Criar produtos
    Product product = new Product("Mx Keys Mini", 220.00);

    // Repositorio de Produtos
    IRepository<Product> repositoryTest = new RepositoryTest<Product>();

    // Cadastrar produtos
    CreateProductService createProductService = new CreateProductService(repositoryTest);
    Product createdProduct = createProductService.execute(product);

    // Buscar produtos
    GetProductService getCourseService = new GetProductService(repositoryTest);
    Product findProduct = getCourseService.execute(createdProduct.getId());

    assertEquals(createdProduct.getId(), findProduct.getId());

  }

  @Test
  public void should_not_be_able_to_get_product_by_wrong_id() {
    // Produtos (id, name, price)

    // Repositorio de Produtos
    IRepository<Product> repositoryTest = new RepositoryTest<Product>();

    GetProductService getCourseService = new GetProductService(repositoryTest);

    // Criando id não existente
    UUID wrongId = UUID.randomUUID();

    Error error = assertThrows(Error.class, () -> {
      // Buscar curso
      getCourseService.execute(wrongId);

    });

    assertEquals("Produto não encontrado!", error.getMessage());

  }

}
