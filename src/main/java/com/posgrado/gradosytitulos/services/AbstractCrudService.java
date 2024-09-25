package com.posgrado.gradosytitulos.services;

import com.posgrado.gradosytitulos.domain.DomainObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
public abstract class AbstractCrudService<T extends DomainObject<ID>, ID> implements CrudService<T, ID> {

    private static final String NOT_FOUND = "Entity not found in database";
    private static final String LOG_NOT_FOUND_UPDATE = "Tried to update a not existing record";
    private static final String LOG_NOT_FOUND_DELETE = "Tried to delete a not existing record";
    protected abstract CrudRepository<T, ID> getRepository();

    @Override
    public T create(T obj) {
        return getRepository().save(obj);
    }

    @Override
    public List<T> findAll() {
        return (List<T>) getRepository().findAll();
    }

    @Override
    public Optional<T> getById(ID id) {
        return getRepository().findById(id);
    }

    @Override
    public T update(ID id, T obj) {
        Optional<T> fetchedObj = getRepository().findById(id);
        if (fetchedObj.isPresent()) {
            obj.setId(id);
            return getRepository().save(obj);
        } else {
            log.error(LOG_NOT_FOUND_UPDATE);
            throw new NoSuchElementException(NOT_FOUND);
        }
    }

    @Override
    public void delete(ID id) {
        Optional<T> toDeleteOpt = getRepository().findById(id);
        if (toDeleteOpt.isPresent()) {
            getRepository().deleteById(id);
        } else {
            log.error(LOG_NOT_FOUND_DELETE);
            throw new NoSuchElementException(NOT_FOUND);

        }
    }
}
