package com.posgrado.gradosytitulos.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.SoftDeleteType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class EntitySuperClass {
    private Boolean status = true;
    @CreatedDate
    private OffsetDateTime created;
    @LastModifiedDate
    private OffsetDateTime updated;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String updatedBy;
}
