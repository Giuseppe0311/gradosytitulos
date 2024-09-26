package com.posgrado.gradosytitulos.dto.mappers.inscription;


import com.posgrado.gradosytitulos.domain.Inscriptions;
import com.posgrado.gradosytitulos.dto.dto.Inscription.InscriptionUpdate;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import com.posgrado.gradosytitulos.repository.ProgramRepository;
import com.posgrado.gradosytitulos.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InscriptionUpdateMapper  implements DTOMapper<InscriptionUpdate, Inscriptions> {

    private final StudentRepository studentRepository;

    private final ProgramRepository programRepository;


    @Override
    public Inscriptions map(InscriptionUpdate inscriptionUpdate) {
        return Inscriptions.builder()
                .student(studentRepository.findById(inscriptionUpdate.idStudent()).orElseThrow(
                        () -> new RuntimeException("Student not found for the inscription")
                ))
                .program(
                        programRepository.findById(inscriptionUpdate.idProgram()).orElseThrow(
                                () -> new RuntimeException("Program not found for the inscription")
                        )
                )
                .inscriptionDate(inscriptionUpdate.inscriptionDate())
                .inscriptionStatus(inscriptionUpdate.incriptionStatus())
                .build();
    }
}
