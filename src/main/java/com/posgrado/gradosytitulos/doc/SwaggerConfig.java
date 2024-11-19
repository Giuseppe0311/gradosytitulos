package com.posgrado.gradosytitulos.doc;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "Ingrese el token JWT generado por keycloak";
        return new OpenAPI()
                .info(new Info().title("Grados y Titulos  - UNIDAD DE POSGRADO")
                        .description("API REST para la gestión de Grados y Titulos")
                        .version("v0.0.1")
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación de Grados y Titulos")
                        .url("https://unsm.edu.pe/oficina/gradosytitulos/"))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(
                        new Components()
                                .addSecuritySchemes(securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                );
    }

}
