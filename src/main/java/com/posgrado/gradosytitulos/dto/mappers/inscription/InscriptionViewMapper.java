package com.posgrado.gradosytitulos.dto.mappers.inscription;

import com.posgrado.gradosytitulos.domain.Inscriptions;
import com.posgrado.gradosytitulos.dto.dto.Inscription.InscriptionView;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import com.posgrado.gradosytitulos.dto.mappers.program.ProgramVieweMapper;
import com.posgrado.gradosytitulos.dto.mappers.students.StudentsViewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InscriptionViewMapper implements DTOMapper<Inscriptions, InscriptionView> {

    private final StudentsViewMapper studentsViewMapper;
    private final ProgramVieweMapper programViewMapper;

    @Override
    public InscriptionView map(Inscriptions inscriptions) {
        return new InscriptionView(
                inscriptions.getId(),
                studentsViewMapper.map(inscriptions.getStudent()),
                programViewMapper.map(inscriptions.getProgram()),
                inscriptions.getInscriptionDate(),
                inscriptions.getInscriptionStatus()

        );
    }
}
