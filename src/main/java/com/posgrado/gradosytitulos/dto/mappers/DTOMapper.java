package com.posgrado.gradosytitulos.dto.mappers;


public interface DTOMapper <Input , Output> {
    Output map(Input input);
}
