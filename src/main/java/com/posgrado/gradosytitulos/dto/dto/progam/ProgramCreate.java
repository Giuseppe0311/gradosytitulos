package com.posgrado.gradosytitulos.dto.dto.progam;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProgramCreate(
        @NotBlank(message = "El campo name es obligatorio")
        String name,
        String description,
        @NotNull(message = "El campo duration es obligatorio")
        @Positive(message = "El campo duration debe ser positivo")
        Integer duration,
        @NotNull(message = "El campo degreeId es obligatorio")
        @Positive(message = "El campo degreeId debe ser positivo")
        Long degreeId
) {
}
