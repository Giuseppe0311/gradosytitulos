package com.posgrado.gradosytitulos.repository;

import com.posgrado.gradosytitulos.domain.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Students,Long> {
}
