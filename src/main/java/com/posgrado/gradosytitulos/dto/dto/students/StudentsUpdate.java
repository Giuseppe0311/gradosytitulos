package com.posgrado.gradosytitulos.dto.dto.students;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record StudentsUpdate(
        @NotBlank(message = "el campo documentNumber no puede estar vacio")
        String documentNumber,
        @NotBlank(message = "el campo name no puede estar vacio")
        String name,
        @NotBlank(message = "el campo paternalSurname no puede estar vacio")
        String paternalSurname,
        @NotBlank(message = "el campo maternalSurname no puede estar vacio")
        String maternalSurname,
        @NotBlank(message = "El campo email no puede estar vacio")
        @Email(message = "Email should be valid")
        String email,
        @NotBlank(message = "El campo phone no puede estar vacio")
        String phone,
        String photo,
        @NotNull(message = "El campo degreeId no puede estar vacio")
        @Positive(message = "El campo degreeId debe ser positivo")
        Long degreeId

) {
}
