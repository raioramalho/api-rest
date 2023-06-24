package br.com.raiosystems.apirest.modules.courses.services;

import org.springframework.stereotype.Service;

import br.com.raiosystems.apirest.entities.Course;
import br.com.raiosystems.apirest.repositories.CourseRepositoryTest;

@Service
public class CreateCourseService {

  private CourseRepositoryTest repository;

  public CreateCourseService(CourseRepositoryTest repository) {
    this.repository = repository;
  }

  public Course execute(Course course) {

    // Validar se o curso existe
    Course findCourse = this.repository.findByName(course.getName());

    // Se sim - retorna erro
    if (findCourse != null) {
      throw new Error("Curso já existe!");
    }

    // se não - retorna novo curso
    return this.repository.save(course);

  }
}
