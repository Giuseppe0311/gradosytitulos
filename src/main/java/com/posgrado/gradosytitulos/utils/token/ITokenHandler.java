package com.posgrado.gradosytitulos.utils.token;


public interface ITokenHandler {
    String getBasicClaimFromToken(String token, String claim);
}
