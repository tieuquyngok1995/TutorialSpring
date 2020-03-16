package spring.boot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"spring.boot.example"})


@SpringBootApplication
public class SpringBootExxampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExxampleApplication.class, args);
	}

}
