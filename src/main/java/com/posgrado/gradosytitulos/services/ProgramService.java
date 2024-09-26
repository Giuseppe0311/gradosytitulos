package com.posgrado.gradosytitulos.services;

import com.posgrado.gradosytitulos.domain.Programs;
import com.posgrado.gradosytitulos.repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProgramService extends AbstractCrudService<Programs,Long> {

    private final ProgramRepository repository;

    @Override
    protected CrudRepository<Programs, Long> getRepository() {
        return repository;
    }
}
