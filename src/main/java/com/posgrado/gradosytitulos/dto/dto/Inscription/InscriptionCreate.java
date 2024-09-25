package com.posgrado.gradosytitulos.dto.dto.Inscription;

import com.posgrado.gradosytitulos.domain.InscriptionStatus;

import java.time.LocalDate;

public record InscriptionCreate(
        Long idStudent,
        Long idProgram,
        LocalDate inscriptionDate,
        InscriptionStatus incriptionStatus
) {
}
