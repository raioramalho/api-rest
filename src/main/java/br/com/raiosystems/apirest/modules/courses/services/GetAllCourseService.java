package br.com.raiosystems.apirest.modules.courses.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.raiosystems.apirest.entities.Course;
import br.com.raiosystems.apirest.repositories.IRepository;

@Service
public class GetAllCourseService {

  private IRepository<Course> repository;

  public GetAllCourseService(IRepository<Course> repository) {
    this.repository = repository;
  }

  public List<Course> execute() {
    // Busca todos os cursos do repositorio
    List<Course> courses = this.repository.getAll();

    // Se estiver vazio
    if (courses.size() <= 0) {
      throw new Error("Nenhum curso encontrado!");
    }

    // Se não estiver vazio
    return this.repository.getAll();
  }

}
