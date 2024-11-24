package com.posgrado.gradosytitulos.dto.dto.Inscription;

import com.posgrado.gradosytitulos.domain.InscriptionStatus;
import com.posgrado.gradosytitulos.dto.dto.progam.ProgramView;
import com.posgrado.gradosytitulos.dto.dto.students.StudentsViewDTO;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public record InscriptionView(
        Long id,
        StudentsViewDTO student,
        ProgramView program,
        LocalDate inscriptionDate,
        InscriptionStatus incriptionStatus,
        Boolean status,
        OffsetDateTime created,
        OffsetDateTime updated,
        String createdBy,
        String updatedBy
) {
}
