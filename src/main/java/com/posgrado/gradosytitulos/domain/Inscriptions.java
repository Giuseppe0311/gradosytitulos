package com.posgrado.gradosytitulos.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class Inscriptions extends EntitySuperClass implements DomainObject<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Students student;
    @ManyToOne
    private Programs program;
    private LocalDate inscriptionDate;
    private  InscriptionStatus inscriptionStatus;

    @Override
    public void changeStatus(Boolean status) {
        this.setStatus(status);
    }
}
