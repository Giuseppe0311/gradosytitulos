package com.posgrado.gradosytitulos.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Degrees extends EntitySuperClass implements DomainObject<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Override
    public void changeStatus(Boolean status) {
        this.setStatus(status);
    }
}
