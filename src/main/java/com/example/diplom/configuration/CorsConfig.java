package com.example.diplom.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // Разрешенные источники запросов
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Разрешенные HTTP методы
                .allowCredentials(false) // Разрешить передачу аутентификационных данных (например, куки)
                .maxAge(3600); // Максимальное время жизни предварительных запросов в секундах
    }
}