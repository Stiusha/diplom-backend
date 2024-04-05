package com.example.diplom.configuration;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Configuration
public class StringsConfiguration {

    @Bean
    public Map<String, String> strings(ObjectMapper objectMapper) throws IOException {
        InputStream inputStream = new ClassPathResource("static/strings.json").getInputStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        JavaType mapType = objectMapper.getTypeFactory().constructMapType(Map.class, String.class, String.class);
        Map<String, String> map = objectMapper.readValue(json, mapType);
        System.out.println(map);
        return map;
    }
}
