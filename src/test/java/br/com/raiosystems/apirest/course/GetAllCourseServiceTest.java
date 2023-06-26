package br.com.raiosystems.apirest.course;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.raiosystems.apirest.entities.Course;
import br.com.raiosystems.apirest.modules.courses.services.CreateCourseService;
import br.com.raiosystems.apirest.modules.courses.services.GetAllCourseService;
import br.com.raiosystems.apirest.repositories.CourseRepositoryTest;
import br.com.raiosystems.apirest.repositories.RepositoryTest;

@SpringBootTest
public class GetAllCourseServiceTest {
  @Test
  public void should_be_able_to_list_all_courses() {
    // Cursos (id, description, name, workload)

    // Criar cursos
    Course course1 = new Course("Description", "Curso_um", 90);
    Course course2 = new Course("Description", "Curso_dois", 120);

    // Repositorio de Cursos
    RepositoryTest<Course> repositoryTest = new RepositoryTest<Course>();

    // Cadastrar cursos
    CreateCourseService createCourseService = new CreateCourseService(repositoryTest);
    createCourseService.execute(course1);
    createCourseService.execute(course2);

    // Listar cursos
    GetAllCourseService getAllCourseServiceTest = new GetAllCourseService(repositoryTest);
    List<Course> courses = getAllCourseServiceTest.execute();

    assertEquals(2, courses.size());

  }

  @Test
  public void should_resolve_error_if_list_is_empty() {
    // Cursos (id, description, name, workload)
    // Repositorio de Cursos
    CourseRepositoryTest repositoryTest = new CourseRepositoryTest();

    // Listar cursos
    GetAllCourseService getAllCourseServiceTest = new GetAllCourseService(repositoryTest);

    Error error = assertThrows(Error.class, () -> {
      // Criar o segundo curso
      getAllCourseServiceTest.execute();
    });

    assertEquals("Nenhum curso encontrado!", error.getMessage());
  }
}
