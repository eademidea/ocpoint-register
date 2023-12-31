package br.com.ocpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("br.com.ocpoint")
@SpringBootApplication
@ComponentScan("br.com.ocpoint")
public class OcpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(OcpointApplication.class, args);
	}

}
