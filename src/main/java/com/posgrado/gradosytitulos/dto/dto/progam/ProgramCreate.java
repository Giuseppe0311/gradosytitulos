package com.posgrado.gradosytitulos.dto.dto.progam;

public record ProgramCreate(
        Long id,
        String name,
        String description,
        Integer duration,
        Long degreeId
) {
}
