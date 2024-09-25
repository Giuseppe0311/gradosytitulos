package com.posgrado.gradosytitulos.dto.mappers.degrees;

import com.posgrado.gradosytitulos.domain.Degrees;
import com.posgrado.gradosytitulos.dto.dto.degrees.DegreesCreate;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import org.springframework.stereotype.Component;

@Component
public class DegreeCreateMapper implements DTOMapper<DegreesCreate, Degrees> {


    @Override
    public Degrees map(DegreesCreate degreesCreate) {
        return Degrees.builder()
                .name(degreesCreate.name())
                .build();
    }
}
