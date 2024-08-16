package com.codegroup.challenge.infrastructure.config.openapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
            .info(new Info().title("Code Group")
                .description("Project Challenge Code Group")
                .version("1.0"));
    }

}