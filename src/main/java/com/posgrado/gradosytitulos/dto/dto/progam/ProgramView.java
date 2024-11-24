package com.posgrado.gradosytitulos.dto.dto.progam;

import com.posgrado.gradosytitulos.dto.dto.degrees.DegreesViewDTO;

import java.time.OffsetDateTime;

public record ProgramView(
        Long id,
        String name,
        String description,
        Integer duration,
        DegreesViewDTO degree,
        Boolean status,
        OffsetDateTime created,
        OffsetDateTime updated,
        String createdBy,
        String updatedBy
) {
}
