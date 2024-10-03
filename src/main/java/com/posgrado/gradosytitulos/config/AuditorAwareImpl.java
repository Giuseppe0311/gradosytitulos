package com.posgrado.gradosytitulos.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || !(authentication instanceof JwtAuthenticationToken)) {
            return Optional.of("anonymous");
        }

        Jwt jwt = ((JwtAuthenticationToken) authentication).getToken();

        String username = jwt.getClaim("preferred_username");

        if (username == null || username.isEmpty()) {
            return Optional.of("anonymous");
        }

        return Optional.of(username);
    }
}
