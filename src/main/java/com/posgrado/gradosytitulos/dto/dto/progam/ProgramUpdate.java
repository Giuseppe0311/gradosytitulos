package com.posgrado.gradosytitulos.dto.dto.progam;

public record ProgramUpdate(
        String name,
        String description,
        Integer duration,
        Long degreeId
) {
}
