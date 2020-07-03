package uk.ac.qub.njoy.dissertation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NjoyApplication {

	public static void main(String[] args) {
		SpringApplication.run(NjoyApplication.class, args);
	}

}
