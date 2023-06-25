package br.com.raiosystems.apirest.modules.courses.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.raiosystems.apirest.entities.Course;
import br.com.raiosystems.apirest.repositories.ICourseRepository;

@Service
public class GetCourseService {

  private ICourseRepository repository;

  public GetCourseService(ICourseRepository repository) {
    this.repository = repository;
  }

  public Course execute(UUID id) {
    return this.repository.findById(id);
  }

}
