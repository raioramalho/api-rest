package br.com.raiosystems.apirest;

import br.com.raiosystems.apirest.database.Conection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("# - STATUS: Rest is running at [ http://localhost:8080 ]");

		try {
			Conection.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@RestController
	@RequestMapping("/")
	public static class AppController {
		@GetMapping
		public Object getApp() {
			return "<center><h3>HelloWorld!</h3>";
		}

	}

}
