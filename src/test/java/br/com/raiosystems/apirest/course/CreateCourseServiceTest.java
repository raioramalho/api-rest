package br.com.raiosystems.apirest.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.raiosystems.apirest.entities.Course;
import br.com.raiosystems.apirest.modules.courses.services.CreateCourseService;
import br.com.raiosystems.apirest.repositories.IRepository;
import br.com.raiosystems.apirest.repositories.RepositoryTest;

@SpringBootTest
public class CreateCourseServiceTest {

  @Test
  public void should_be_able_to_create_a_new_course() {
    // Cursos (id, description, name, workload)

    // Criar Entidade
    Course course = new Course();
    course.setDescription("Curso_Description");
    course.setName("Curso_name");
    course.setWorkload(100);

    // Criar Repositorio de Curso
    IRepository<Course> repositoryTest = new RepositoryTest<Course>();

    // Criar um novo Service
    CreateCourseService createCourseService = new CreateCourseService(repositoryTest);

    // Cadastrar um novo Curso
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

    // Criar Repositorio de Curso
    IRepository<Course> repositoryTest = new RepositoryTest<Course>();

    // Criar um novo Service
    CreateCourseService createCourseService = new CreateCourseService(repositoryTest);
    // Cadastrar o primeiro curso
    createCourseService.execute(course);

    Error error = assertThrows(Error.class, () -> {
      // Cadastrar o segundo curso
      createCourseService.execute(course);
    });

    assertEquals("Curso já cadastrado!", error.getMessage());

  }

}
