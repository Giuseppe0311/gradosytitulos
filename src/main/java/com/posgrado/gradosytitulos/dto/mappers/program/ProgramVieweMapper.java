package com.posgrado.gradosytitulos.dto.mappers.program;

import com.posgrado.gradosytitulos.domain.Programs;
import com.posgrado.gradosytitulos.dto.dto.progam.ProgramView;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import com.posgrado.gradosytitulos.dto.mappers.degrees.DegreeViewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProgramVieweMapper implements DTOMapper<Programs, ProgramView> {

    private final DegreeViewMapper degreeViewMapper;

    @Override
    public ProgramView map(Programs programs) {
        return new ProgramView(
                programs.getId(),
                programs.getName(),
                programs.getDescription(),
                programs.getDuration(),
                degreeViewMapper.map(programs.getDegree())
        );
    }
}
