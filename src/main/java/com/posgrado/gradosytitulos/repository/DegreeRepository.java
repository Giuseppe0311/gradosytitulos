package com.posgrado.gradosytitulos.repository;

import com.posgrado.gradosytitulos.domain.Degrees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degrees, Long> {
}
