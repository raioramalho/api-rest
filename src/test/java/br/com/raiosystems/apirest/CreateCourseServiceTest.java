package br.com.raiosystems.apirest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.raiosystems.apirest.entities.Course;
import br.com.raiosystems.apirest.modules.courses.services.CreateCourseService;
import br.com.raiosystems.apirest.repositories.CourseRepositoryTest;
import net.bytebuddy.implementation.bytecode.Throw;

@SpringBootTest
public class CreateCourseServiceTest {

  @Test
  public void should_be_able_to_create_a_new_course() {
    // Criar um novo Curso
    // Criar table Cursos (id, description, name, workload)

    // Criar Entidade
    Course course = new Course();
    course.setDescription("Curso_Description");
    course.setName("Curso_name");
    course.setWorkload(100);

    // Criar Repositorio de Curso
    CourseRepositoryTest repositoryTest = new CourseRepositoryTest();

    // Criar um novo Service
    CreateCourseService createCourseService = new CreateCourseService(repositoryTest);
    Course createCourse = createCourseService.execute(course);

    assertNotNull(createCourse.getId());
  }

  @Test
  public void should_not_be_able_to_create_new_course_if_exists() {
    // Criar Entidade
    Course course = new Course();
    course.setDescription("Curso_Description");
    course.setName("Curso_name");
    course.setWorkload(100);

    assertThrows(Error.class, () -> {
      // Criar Repositorio de Curso
      CourseRepositoryTest repositoryTest = new CourseRepositoryTest();
      // Criar um novo Service
      CreateCourseService createCourseService = new CreateCourseService(repositoryTest);
      // Criar o primeiro
      createCourseService.execute(course);
      // Erro
      createCourseService.execute(course);
    }, "");

  }

}
