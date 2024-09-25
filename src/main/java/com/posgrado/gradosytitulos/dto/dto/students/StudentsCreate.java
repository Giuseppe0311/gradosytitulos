package com.posgrado.gradosytitulos.dto.dto.students;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentsCreate (
        @NotBlank
        String documentNumber,
        @NotBlank
        String name,
        @NotBlank
        String paternalSurname,
        @NotBlank
        String maternalSurname,
        @NotBlank
        String email,
        @NotBlank
        String phone,
        @NotNull
        Integer degreeId,
        String photo
) {
}
