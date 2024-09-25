package com.posgrado.gradosytitulos.services;

import com.posgrado.gradosytitulos.domain.Students;
import com.posgrado.gradosytitulos.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentsService extends AbstractCrudService<Students,Long>{
    private  final StudentRepository repository;

    @Override
    protected CrudRepository<Students, Long> getRepository() {
        return repository;
    }
}
