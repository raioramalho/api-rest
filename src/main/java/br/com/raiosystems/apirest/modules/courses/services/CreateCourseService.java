package br.com.raiosystems.apirest.modules.courses.services;

import org.springframework.stereotype.Service;

import br.com.raiosystems.apirest.entities.Course;
import br.com.raiosystems.apirest.repositories.ICourseRepository;

@Service
public class CreateCourseService {

  private ICourseRepository repository;

  public CreateCourseService(ICourseRepository repository) {
    this.repository = repository;
  }

  public Course execute(Course course) {

    // Validar se o curso existe
    Course findCourse = this.repository.findByName(course.getName());

    // Se sim - retorna erro
    if (findCourse != null) {
      throw new Error("Curso já cadastrado!");
    }

    // Se não - retorna novo curso
    return this.repository.save(course);

  }
}
