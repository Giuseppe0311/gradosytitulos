package com.posgrado.gradosytitulos.utils.token;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TokenHandlerImpl implements ITokenHandler {

    private final JwtDecoder jwtDecoder;

    @Override
    public String getBasicClaimFromToken(String token,String claim) {
        Jwt jwt = jwtDecoder.decode(token);
       return Optional.ofNullable(jwt.getClaim(claim))
               .map(Object::toString)
               .orElse(null);
    }
}
