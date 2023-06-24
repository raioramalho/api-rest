package br.com.raiosystems.apirest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.raiosystems.apirest.entities.Course;
import br.com.raiosystems.apirest.modules.courses.services.CreateCourseService;
import br.com.raiosystems.apirest.modules.courses.services.GetAllCourseService;
import br.com.raiosystems.apirest.repositories.CourseRepositoryTest;

@RestController
@RequestMapping("/courses")
public class CourseController {

  CourseRepositoryTest repository = new CourseRepositoryTest();
  private CreateCourseService createCourseService = new CreateCourseService(repository);
  private GetAllCourseService getAllCourseService = new GetAllCourseService(repository);

  @PostMapping
  public Course createCourse(@RequestBody Course course) {
    Course response = this.createCourseService.execute(course);
    return response;
  }

  @GetMapping
  public List<Course> listCourses() {
    List<Course> response = this.getAllCourseService.execute();
    return response;
  }

}
