package com.posgrado.gradosytitulos.dto.mappers.program;


import com.posgrado.gradosytitulos.domain.Program;
import com.posgrado.gradosytitulos.dto.dto.progam.ProgramUpdate;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import com.posgrado.gradosytitulos.repository.DegreeRepository;
import com.posgrado.gradosytitulos.repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProgramUpdateMapper implements DTOMapper<ProgramUpdate, Program> {

    private final DegreeRepository repository;

    @Override
    public Program map(ProgramUpdate programUpdate) {
        return Program.builder()
                .name(programUpdate.name())
                .description(programUpdate.description())
                .duration(programUpdate.duration())
                .degree(repository.findById(programUpdate.degreeId()).orElseThrow(
                        () -> new RuntimeException("Degree not found for the program")
                ))
                .build();
    }
}
