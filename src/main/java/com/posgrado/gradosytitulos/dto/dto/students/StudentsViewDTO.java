package com.posgrado.gradosytitulos.dto.dto.students;

import java.time.OffsetDateTime;

public record StudentsViewDTO(
        Long id,
        String documentNumber,
        String name,
        String paternalSurname,
        String maternalSurname,
        String email,
        String phone,
        Long degreeId,
        String photo,
        Boolean status,
        OffsetDateTime created,
        OffsetDateTime updated,
        String createdBy,
        String updatedBy
) {
}
