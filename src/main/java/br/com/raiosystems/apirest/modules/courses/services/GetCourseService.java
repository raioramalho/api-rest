package br.com.raiosystems.apirest.modules.courses.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.raiosystems.apirest.entities.Course;
import br.com.raiosystems.apirest.repositories.IRepository;

@Service
public class GetCourseService {

  private IRepository<Course> repository;

  public GetCourseService(IRepository<Course> repository) {
    this.repository = repository;
  }

  public Course execute(UUID id) {
    Course findCourse = this.repository.findById(id);

    if (findCourse == null) {
      throw new Error("Curso não encontrado!");
    }

    return findCourse;
  }

}
