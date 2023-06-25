package br.com.raiosystems.apirest.repositories;

import java.util.List;
import java.util.UUID;

import br.com.raiosystems.apirest.entities.Course;

public interface ICourseRepository {

  public Course findByName(String name);

  public Course findById(UUID id);

  public List<Course> getAll();

  public Course save(Course course);

}
