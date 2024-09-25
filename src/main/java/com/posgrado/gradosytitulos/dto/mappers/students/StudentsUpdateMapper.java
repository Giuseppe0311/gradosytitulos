package com.posgrado.gradosytitulos.dto.mappers.students;

import com.posgrado.gradosytitulos.domain.Students;
import com.posgrado.gradosytitulos.dto.dto.students.StudentsUpdate;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentsUpdateMapper  implements DTOMapper<StudentsUpdate, Students> {
    @Override
    public Students map(StudentsUpdate studentsUpdate) {
        Students student = new Students();
        student.setDocumentNumber(studentsUpdate.documentNumber());
        student.setName(studentsUpdate.name());
        student.setPaternalSurname(studentsUpdate.paternalSurname());
        student.setMaternalSurname(studentsUpdate.maternalSurname());
        student.setEmail(studentsUpdate.email());
        student.setPhone(studentsUpdate.phone());
        student.setGradeId(studentsUpdate.degreeId());
        student.setPhoto(studentsUpdate.photo());
        return student;
    }
}
