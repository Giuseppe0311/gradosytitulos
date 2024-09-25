package com.posgrado.gradosytitulos.dto.mappers.program;

import com.posgrado.gradosytitulos.domain.Program;
import com.posgrado.gradosytitulos.dto.dto.progam.ProgramCreate;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import com.posgrado.gradosytitulos.repository.DegreeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProgramCreateMapper implements DTOMapper<ProgramCreate, Program> {

    private final DegreeRepository repository;

    @Override
    public Program map(ProgramCreate programCreate) {
        return Program.builder()
                .name(programCreate.name())
                .description(programCreate.description())
                .duration(programCreate.duration())
                .degree(repository.findById(programCreate.degreeId()).orElseThrow(
                        () -> new RuntimeException("Degree not found for the program")
                ))
                .build();
    }
}
