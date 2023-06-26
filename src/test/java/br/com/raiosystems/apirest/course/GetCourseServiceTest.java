package br.com.raiosystems.apirest.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import br.com.raiosystems.apirest.entities.Course;
import br.com.raiosystems.apirest.modules.courses.services.CreateCourseService;
import br.com.raiosystems.apirest.modules.courses.services.GetCourseService;
import br.com.raiosystems.apirest.repositories.IRepository;
import br.com.raiosystems.apirest.repositories.RepositoryTest;

public class GetCourseServiceTest {
  @Test
  public void should_be_able_to_get_course_by_id() {
    // Cursos (id, description, name, workload)

    // Criar curso
    Course course = new Course("Description", "Curso_de_TDD", 70);

    // Repositorio de Curso
    IRepository<Course> repositoryTest = new RepositoryTest<Course>();

    // Cadastrar curso
    CreateCourseService createCourseService = new CreateCourseService(repositoryTest);
    Course createdCourse = createCourseService.execute(course);

    // Buscar curso
    GetCourseService getCourseService = new GetCourseService(repositoryTest);

    Course findCourse = getCourseService.execute(createdCourse.getId());

    assertEquals(createdCourse.getId(), findCourse.getId());

  }

  @Test
  public void should_not_be_able_to_get_course_by_wrong_id() {
    // Cursos (id, description, name, workload)

    // Repositorio de Curso
    IRepository<Course> repositoryTest = new RepositoryTest<Course>();

    GetCourseService getCourseService = new GetCourseService(repositoryTest);

    // Criando id não existente
    UUID wrongId = UUID.randomUUID();


    Error error = assertThrows(Error.class, () -> {
      // Buscar curso
      getCourseService.execute(wrongId);

    });

    assertEquals("Curso não encontrado!", error.getMessage());
  }
}
