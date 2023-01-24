package ru.vsu.csf.alcomanager.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("alcoManager")
                .packagesToScan("ru.vsu.csf.alcomanager.controller")
                .pathsToMatch("/*")
                .build();
    }
}