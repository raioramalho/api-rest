package br.com.raiosystems.apirest;

import br.com.raiosystems.apirest.database.Conection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
		System.out.println("# - STATUS: Rest is running at [ http://localhost:8080 ]");
		Conection.execute();
	}

	@RestController
	@RequestMapping("/")
	public class AppController {

		@GetMapping
		public Object getApp() {
			return "<center><h3>HelloWorld!</h3>";
		}

	}

}
