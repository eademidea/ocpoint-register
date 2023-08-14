package br.com.ocpoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.com")
public class OcpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(OcpointApplication.class, args);
	}

}