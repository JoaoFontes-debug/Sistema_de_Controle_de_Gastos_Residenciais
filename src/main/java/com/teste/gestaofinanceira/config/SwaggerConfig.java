package com.teste.gestaofinanceira.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("Financial management")
                            .description("API for management of residential expenses")
                            .version("1.0.0")
                    );
        }

        @Bean
        public GroupedOpenApi publicApi() {
            return GroupedOpenApi.builder()
                    .group("public")
                    .packagesToScan("com.teste.gestaofinanceira.controller")
                    .build();
        }
}
