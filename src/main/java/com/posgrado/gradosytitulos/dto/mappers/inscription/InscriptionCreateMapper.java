package com.posgrado.gradosytitulos.dto.mappers.inscription;

import com.posgrado.gradosytitulos.domain.Inscriptions;
import com.posgrado.gradosytitulos.dto.dto.Inscription.InscriptionCreate;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import com.posgrado.gradosytitulos.repository.ProgramRepository;
import com.posgrado.gradosytitulos.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InscriptionCreateMapper implements DTOMapper<InscriptionCreate, Inscriptions> {

    private final StudentRepository studentRepository;
    private final ProgramRepository programRepository;


    @Override
    public Inscriptions map(InscriptionCreate inscriptionCreate) {
        return Inscriptions.builder()
                .student(
                        studentRepository.findById(inscriptionCreate.idStudent()).orElseThrow(
                                () -> new RuntimeException("Student not found for the inscription")
                        )
                )
                .program(
                        programRepository.findById(inscriptionCreate.idProgram()).orElseThrow(
                                () -> new RuntimeException("Program not found for the inscription")
                        )
                )
                .inscriptionDate(inscriptionCreate.inscriptionDate())
                .inscriptionStatus(inscriptionCreate.incriptionStatus())
                .build();
    }
}
