package com.posgrado.gradosytitulos.dto.dto.progam;

import com.posgrado.gradosytitulos.dto.dto.degrees.DegreesViewDTO;

public record ProgramView(
        Long id,
        String name,
        String description,
        Integer duration,
        DegreesViewDTO degree
) {
}
