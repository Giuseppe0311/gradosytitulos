package com.posgrado.gradosytitulos.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;

@MappedSuperclass
@SQLRestriction("status = true")
@SoftDelete(columnName = "status", strategy = SoftDeleteType.ACTIVE)
@Getter
@Setter
public class EntitySuperClass {
    @Column(insertable = false, updatable = false)
    private Boolean status = true;
}
