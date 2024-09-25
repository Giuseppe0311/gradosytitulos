package com.posgrado.gradosytitulos.dto.mappers.program;

import com.posgrado.gradosytitulos.domain.Program;
import com.posgrado.gradosytitulos.dto.dto.progam.ProgramView;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import com.posgrado.gradosytitulos.dto.mappers.degrees.DegreeViewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProgramVieweMapper implements DTOMapper<Program, ProgramView> {

    private final DegreeViewMapper degreeViewMapper;

    @Override
    public ProgramView map(Program program) {
        return new ProgramView(
                program.getId(),
                program.getName(),
                program.getDescription(),
                program.getDuration(),
                degreeViewMapper.map(program.getDegree())
        );
    }
}
