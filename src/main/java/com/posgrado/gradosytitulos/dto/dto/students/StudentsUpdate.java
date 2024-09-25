package com.posgrado.gradosytitulos.dto.dto.students;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StudentsUpdate(
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
        @NotBlank
        String photo,
        @NotNull
        Integer degreeId

) {
}
