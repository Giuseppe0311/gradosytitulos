package com.posgrado.gradosytitulos.dto.dto.degrees;

import java.time.OffsetDateTime;

public record DegreesViewDTO(
        Long id,
        String name,
        Boolean status,
        OffsetDateTime created,
        OffsetDateTime updated,
        String createdBy,
        String updatedBy
) {
}
