package com.posgrado.gradosytitulos.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticación", description = "API de autenticación")
public class AuthController {

    @Value("${keycloack.url}")
    String tokenUrl;

    private final RestTemplate restTemplate;



    @Operation(
            summary = "Login",
            description = "Realiza el login en el sistema",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(
                            mediaType = MediaType.APPLICATION_FORM_URLENCODED_VALUE
                    )
            )
    )
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(
            @Parameter(description = "Nombre de usuario", required = true) @RequestParam String username,
            @Parameter(description = "Contraseña", required = true) @RequestParam String password
    ) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String,String> map = new LinkedMultiValueMap<>();
        map.add("username", username);
        map.add("password", password);
        map.add("grant_type", "password");
        map.add("client_id", "gradosytitulos");
        map.add("client_secret", "l2LKNTT7qIeWHrOIcNYEB2fpLrlqsF7K");
        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(map,headers);
        ResponseEntity<KeycloackAuthResponse> response = restTemplate.exchange(tokenUrl,
                HttpMethod.POST,
                entity,
                KeycloackAuthResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok(response.getBody());
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }
}
