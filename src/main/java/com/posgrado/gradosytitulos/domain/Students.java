package com.posgrado.gradosytitulos.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Students extends EntitySuperClass implements DomainObject<Long>  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documentNumber;
    private String name;
    private String paternalSurname;
    private String maternalSurname;
    private String email;
    private String phone;
    private Long gradeId;
    private String photo;

}
