package com.posgrado.gradosytitulos.services;

import com.posgrado.gradosytitulos.domain.Degrees;
import com.posgrado.gradosytitulos.repository.DegreeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DegreeService extends AbstractCrudService<Degrees,Long>{
    private final DegreeRepository repository;
    @Override
    protected CrudRepository<Degrees, Long> getRepository() {
        return repository;
    }
}
