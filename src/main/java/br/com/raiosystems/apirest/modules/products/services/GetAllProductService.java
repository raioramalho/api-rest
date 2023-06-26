package br.com.raiosystems.apirest.modules.products.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.raiosystems.apirest.entities.Product;
import br.com.raiosystems.apirest.repositories.IRepository;

@Service
public class GetAllProductService {

  private IRepository<Product> repository;

  public GetAllProductService(IRepository<Product> repository) {
    this.repository = repository;
  }

  public List<Product> execute() {
    // Busca todos os cursos do repositorio
    List<Product> products = this.repository.getAll();

    // Se estiver vazio
    if (products.size() <= 0) {
      throw new Error("Nenhum produto encontrado!");
    }

    // Se não estiver vazio
    return this.repository.getAll();
  }

}
