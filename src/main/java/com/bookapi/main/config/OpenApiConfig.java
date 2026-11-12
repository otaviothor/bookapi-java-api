package com.bookapi.main.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI bookapiOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("BookAPI")
                        .description("API for managing books and user interactions")
                        .version("1.0.0"));
    }
}