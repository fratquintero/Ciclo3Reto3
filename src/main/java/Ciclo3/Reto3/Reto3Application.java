// 1. Model or Entity: where tables are built
// 2. Interface : with the CRUD methods
// 3. Repository : with methods for using CRUD
// 4. Services: contains conditions for the JSON
// 5. Web controller: the URL for the API REST is created

package Ciclo3.Reto3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"Ciclo3.Reto3.model"})
public class Reto3Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto3Application.class, args);
	}

}
