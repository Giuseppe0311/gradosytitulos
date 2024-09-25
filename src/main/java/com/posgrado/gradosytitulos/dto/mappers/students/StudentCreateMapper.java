package com.posgrado.gradosytitulos.dto.mappers.students;

import com.posgrado.gradosytitulos.domain.Students;
import com.posgrado.gradosytitulos.dto.dto.students.StudentsCreate;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import org.springframework.stereotype.Component;

@Component

//TODO : validar la existencia del id del grado
public class StudentCreateMapper implements DTOMapper<StudentsCreate, Students> {
    @Override
    public Students map(StudentsCreate input) {
        Students student = new Students();
        student.setDocumentNumber(input.documentNumber());
        student.setName(input.name());
        student.setPaternalSurname(input.paternalSurname());
        student.setMaternalSurname(input.maternalSurname());
        student.setEmail(input.email());
        student.setPhone(input.phone());
        student.setGradeId(input.degreeId());
        student.setPhoto(input.photo());
        return student;
    }
}
