package com.posgrado.gradosytitulos.dto.mappers.degrees;

import com.posgrado.gradosytitulos.domain.Degrees;
import com.posgrado.gradosytitulos.dto.dto.degrees.DegreesViewDTO;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import org.springframework.stereotype.Component;

@Component
public class DegreeViewMapper implements DTOMapper<Degrees, DegreesViewDTO> {
    @Override
    public DegreesViewDTO map(Degrees degrees) {
        return new DegreesViewDTO(
                degrees.getId(),
                degrees.getName(),
                degrees.getStatus(),
                degrees.getCreated(),
                degrees.getUpdated(),
                degrees.getCreatedBy(),
                degrees.getUpdatedBy()
        );
    }
}
