package com.posgrado.gradosytitulos.dto.mappers.students;

import com.posgrado.gradosytitulos.domain.Students;
import com.posgrado.gradosytitulos.dto.dto.students.StudentsViewDTO;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentsViewMapper implements DTOMapper<Students, StudentsViewDTO> {

    @Override
    public StudentsViewDTO map(Students students) {
        return new StudentsViewDTO(
                students.getId(),
                students.getDocumentNumber(),
                students.getName(),
                students.getPaternalSurname(),
                students.getMaternalSurname(),
                students.getEmail(),
                students.getPhone(),
                students.getGradeId(),
                students.getPhoto(),
                students.getStatus(),
                students.getCreated(),
                students.getUpdated(),
                students.getCreatedBy(),
                students.getUpdatedBy()
        );
    }
}
