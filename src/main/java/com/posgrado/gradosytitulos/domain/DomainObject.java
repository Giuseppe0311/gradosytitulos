package com.posgrado.gradosytitulos.domain;

public interface DomainObject<K> {
    void setId(K id);
    void changeStatus(Boolean status);
}
