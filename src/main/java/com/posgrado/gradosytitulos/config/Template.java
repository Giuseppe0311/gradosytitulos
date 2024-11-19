package com.posgrado.gradosytitulos.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Template {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }
}
