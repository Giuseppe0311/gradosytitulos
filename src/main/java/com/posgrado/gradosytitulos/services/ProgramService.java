package com.posgrado.gradosytitulos.services;

import com.posgrado.gradosytitulos.domain.Program;
import com.posgrado.gradosytitulos.repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramService extends AbstractCrudService<Program,Long> {

    private final ProgramRepository repository;

    @Override
    protected CrudRepository<Program, Long> getRepository() {
        return repository;
    }
}
