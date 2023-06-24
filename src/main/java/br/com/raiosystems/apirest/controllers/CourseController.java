package br.com.raiosystems.apirest.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.raiosystems.apirest.entities.Course;
import br.com.raiosystems.apirest.modules.courses.services.CreateCourseService;
import br.com.raiosystems.apirest.repositories.CourseRepositoryTest;

@RestController
@RequestMapping("/courses")
public class CourseController {

  CourseRepositoryTest repository = new CourseRepositoryTest();
  private CreateCourseService createCourseService = new CreateCourseService(repository);

  @PostMapping
  public Course createCourse(@RequestBody Course course) {
    return this.createCourseService.execute(course);
  }

}
