package com.posgrado.gradosytitulos.repository;

import com.posgrado.gradosytitulos.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program, Long> {
}
