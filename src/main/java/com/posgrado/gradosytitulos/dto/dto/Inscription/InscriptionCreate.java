package com.posgrado.gradosytitulos.dto.dto.Inscription;

import com.posgrado.gradosytitulos.domain.InscriptionStatus;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record InscriptionCreate(
        @NotNull(message = "El campo idEstudiante es obligatorio")
        @Positive(message = "El campo idEstudiante debe ser positivo")
        Long idStudent,
        @NotNull(message = "El campo idPrograma es obligatorio")
        @Positive(message = "El campo idPrograma debe ser positivo")
        Long idProgram,
        @NotNull(message = "El campo fechaInscripcion es obligatorio")
        LocalDate inscriptionDate,
        @NotNull(message = "El campo inscripcionStatus es obligatorio")
        InscriptionStatus incriptionStatus
) {
}
