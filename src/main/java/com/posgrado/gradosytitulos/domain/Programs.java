package com.posgrado.gradosytitulos.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Programs extends EntitySuperClass implements DomainObject<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer duration;
    @ManyToOne
    private  Degrees degree;

    @Override
    public void changeStatus(Boolean status) {
        this.setStatus(status);
    }
}
