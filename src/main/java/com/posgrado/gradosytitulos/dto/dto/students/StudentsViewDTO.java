package com.posgrado.gradosytitulos.dto.dto.students;

public record StudentsViewDTO(
        Long id,
        String documentNumber,
        String name,
        String paternalSurname,
        String maternalSurname,
        String email,
        String phone,
        Integer degreeId,
        String photo
) {
}
