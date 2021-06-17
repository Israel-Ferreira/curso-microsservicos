package io.codekaffee.bookservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "book-service-api", 
        version = "v1", 
        description = "Documentation of Book service api"
    )
)
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI();
    }

}
