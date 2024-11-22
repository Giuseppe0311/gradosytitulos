package com.posgrado.gradosytitulos.dto.dto.degrees;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DegreesCreate(
        @NotBlank(message = "El campo nombre es obligatorio")
        String name
) {
}
