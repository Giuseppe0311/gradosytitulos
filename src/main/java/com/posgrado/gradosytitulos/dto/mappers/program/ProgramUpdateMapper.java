package com.posgrado.gradosytitulos.dto.mappers.program;


import com.posgrado.gradosytitulos.domain.Programs;
import com.posgrado.gradosytitulos.dto.dto.progam.ProgramUpdate;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import com.posgrado.gradosytitulos.repository.DegreeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProgramUpdateMapper implements DTOMapper<ProgramUpdate, Programs> {

    private final DegreeRepository repository;

    @Override
    public Programs map(ProgramUpdate programUpdate) {
        return Programs.builder()
                .name(programUpdate.name())
                .description(programUpdate.description())
                .duration(programUpdate.duration())
                .degree(repository.findById(programUpdate.degreeId()).orElseThrow(
                        () -> new RuntimeException("Degree not found for the program")
                ))
                .build();
    }
}
