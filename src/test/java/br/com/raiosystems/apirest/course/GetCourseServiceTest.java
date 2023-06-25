package br.com.raiosystems.apirest.course;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.raiosystems.apirest.entities.Course;
import br.com.raiosystems.apirest.modules.courses.services.CreateCourseService;
import br.com.raiosystems.apirest.modules.courses.services.GetCourseService;
import br.com.raiosystems.apirest.repositories.CourseRepositoryTest;

public class GetCourseServiceTest {
  @Test
  public void should_be_able_to_list_course_by_id() {
    // Cursos (id, description, name, workload)

    // Criar curso
    Course course = new Course("Description", "Curso_de_TDD", 70);

    // Repositorio de Curso
    CourseRepositoryTest repositoryTest = new CourseRepositoryTest();

    // Cadastrar curso
    CreateCourseService createCourseService = new CreateCourseService(repositoryTest);
    Course createdCourse = createCourseService.execute(course);

    // Buscar curso
    GetCourseService getCourseService = new GetCourseService(repositoryTest);

    Course findCourse = getCourseService.execute(createdCourse.getId());

    assertEquals(createdCourse.getId(), findCourse.getId());

  }
}
