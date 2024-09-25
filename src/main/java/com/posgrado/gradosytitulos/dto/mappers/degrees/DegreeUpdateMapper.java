package com.posgrado.gradosytitulos.dto.mappers.degrees;

import com.posgrado.gradosytitulos.domain.Degrees;
import com.posgrado.gradosytitulos.dto.dto.degrees.DegreesUpdate;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import org.springframework.stereotype.Component;

@Component
public class DegreeUpdateMapper implements DTOMapper<DegreesUpdate, Degrees> {
    @Override
    public Degrees map(DegreesUpdate degreesUpdate) {
        return Degrees.builder()
                .name(degreesUpdate.name())
                .build();
    }
}
