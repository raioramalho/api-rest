package br.com.raiosystems.apirest.modules.courses.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.raiosystems.apirest.entities.Course;
import br.com.raiosystems.apirest.repositories.CourseRepositoryTest;

@Service
public class GetCourseService {

  private CourseRepositoryTest repository;

  public GetCourseService(CourseRepositoryTest repository) {
    this.repository = repository;
  }

  public Course execute(UUID id) {
    return this.repository.findById(id);
  }

}
