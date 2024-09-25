package com.posgrado.gradosytitulos.dto.dto.Inscription;

import com.posgrado.gradosytitulos.domain.InscriptionStatus;
import com.posgrado.gradosytitulos.dto.dto.progam.ProgramView;
import com.posgrado.gradosytitulos.dto.dto.students.StudentsViewDTO;

import java.time.LocalDate;

public record InscriptionView(
        Long id,
        StudentsViewDTO student,
        ProgramView program,
        LocalDate inscriptionDate,
        InscriptionStatus incriptionStatus
) {
}
