package com.posgrado.gradosytitulos.services;

import com.posgrado.gradosytitulos.domain.Inscriptions;
import com.posgrado.gradosytitulos.repository.InscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InscriptionService extends AbstractCrudService<Inscriptions,Long>{
    private final InscriptionRepository repository;
    @Override
    protected CrudRepository<Inscriptions, Long> getRepository() {
        return repository;
    }
}
