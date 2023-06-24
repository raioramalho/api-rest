package br.com.raiosystems.apirest.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.raiosystems.apirest.entities.Product;
import br.com.raiosystems.apirest.modules.products.services.CreateProductService;
import br.com.raiosystems.apirest.repositories.ProductRepositoryTest;

public class CreateProductServiceTest {
  @Test
  public void should_be_able_to_create_a_new_product() {
    // Produtos (id, name, price)

    // Criar Entidade
    Product produto = new Product();
    produto.setName("Mx Keys Mini");
    produto.setPrice(200.00);

    // Criar Repositorio de Product
    ProductRepositoryTest repositoryTest = new ProductRepositoryTest();

    // Criar um novo Service
    CreateProductService createProductServiceTest = new CreateProductService(repositoryTest);

    // Cadastrar um novo Produto
    Product newProduct = createProductServiceTest.execute(produto);

    assertNotNull(newProduct.getId());
  }

  @Test
  public void should_not_be_able_to_create_new_product_if_exists() {
    // Criar Entidade
    Product produto = new Product();
    produto.setName("Mx Keys Mini");
    produto.setPrice(200.00);

    // Criar Repositorio de Product
    ProductRepositoryTest repositoryTest = new ProductRepositoryTest();

    // Criar um novo Service
    CreateProductService createProductServiceTest = new CreateProductService(repositoryTest);

    // Cadastrar o primeiro Produto
    createProductServiceTest.execute(produto);

    Error error = assertThrows(Error.class, () -> {
      // Cadastrar o segundo curso
      createProductServiceTest.execute(produto);
    });

    assertEquals("Produto já cadastrado!", error.getMessage());

  }
}
