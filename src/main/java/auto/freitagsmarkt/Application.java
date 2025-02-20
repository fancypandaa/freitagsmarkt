package auto.freitagsmarkt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "auto.freitagsmarkt")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
