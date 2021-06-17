package io.codekaffee.cambioservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;


@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "cambio-service",
        version = "v1",
        description = "Documentation of Cambio Service Api"
    )
)
public class OpenApiConfig {
    
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI();
    }
}
