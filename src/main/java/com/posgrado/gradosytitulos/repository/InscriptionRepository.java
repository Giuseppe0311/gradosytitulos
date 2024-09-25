package com.posgrado.gradosytitulos.repository;

import com.posgrado.gradosytitulos.domain.Inscriptions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscriptions,Long> {
}
