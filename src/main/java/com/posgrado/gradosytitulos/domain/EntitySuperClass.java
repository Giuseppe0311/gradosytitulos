package com.posgrado.gradosytitulos.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;

@MappedSuperclass
@SQLRestriction("estado = true")
@SoftDelete(columnName = "estado", strategy = SoftDeleteType.ACTIVE)
@Getter
@Setter
public class EntitySuperClass {
    @Column(name = "estado", insertable = false, updatable = false)
    private Boolean status = true;
}
