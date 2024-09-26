package com.posgrado.gradosytitulos.repository;

import com.posgrado.gradosytitulos.domain.Programs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Programs, Long> {
}
