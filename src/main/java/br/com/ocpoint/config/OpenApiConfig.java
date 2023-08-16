package br.com.ocpoint.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@OpenAPIDefinition(
    info = @io.swagger.v3.oas.annotations.info.Info(
        title = "ocpoint-user-ms",
        description = "Microserviço responsavel pela gestão de usuários do OCPOINT",
        version = "${springdoc.version}"
    )
)
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("ocpoint ms")
                        .description("Microservice para criar ocorrencia de ponto.")
                        .version("1.0"));
    }
}