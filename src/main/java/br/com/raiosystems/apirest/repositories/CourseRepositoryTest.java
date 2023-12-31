package br.com.raiosystems.apirest.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.raiosystems.apirest.entities.Course;

@Repository
public class CourseRepositoryTest implements IRepository<Course>{

  private List<Course> courses;

  public CourseRepositoryTest() {
    this.courses = new ArrayList<Course>();
  }

  public List<Course> getAll() {
    return courses;
  }

  public Course findByName(String name) {
    Optional<Course> findCourse = this.courses.stream().filter(courses -> courses.getName().equals(name)).findFirst();
    return findCourse.orElse(null);
  }

  public Course findById(UUID id) {
    Optional<Course> findCourse = this.courses.stream().filter(courses -> courses.getId().equals(id)).findFirst();
    return findCourse.orElse(null);
  }

  public Course save(Course course) {
    this.courses.add(course);
    course.setId(UUID.randomUUID());
    return course;
  }
}
