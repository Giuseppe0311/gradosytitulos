package com.posgrado.gradosytitulos.rest;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import com.posgrado.gradosytitulos.services.CrudService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public abstract class AbstractCrudController<C, U, V, T, ID> implements CrudController<C, U, V> {

    private static final String NOT_FOUND = "Entity not found in database";
    private static final String ERROR_ID = "Error during getting the id";

    protected abstract CrudService<T, ID> getService();

    protected abstract DTOMapper<C, T> getCreateDtoMapper();

    protected abstract DTOMapper<U, T> getUpdateDtoMapper();

    protected abstract DTOMapper<T, V> getViewDtoMapper();

    protected abstract DTOMapper<Map<String, String>, ID> getIdMapper();

    @Override
    public List<V> getAll() {
        return getService().findAll()
                .stream()
                .map(this.getViewDtoMapper()::map)
                .toList();
    }

    @Override
    public V getById(Map<String, String> idMap) {
        ID id;
        try {
            id = this.getIdMapper().map(idMap);
        } catch (Exception e) {
            throw new RuntimeException(ERROR_ID);
        }
        return this.getViewDtoMapper().map(getService().getById(id).orElseThrow(
                () -> new NoSuchElementException(NOT_FOUND)
        ));
    }

    @Override
    public V create(C createDTO) {
        return this.getViewDtoMapper()
                .map(this.getService().create(this.getCreateDtoMapper()
                                .map(createDTO)
                        )
                );
    }

    @Override
    public V update(U updateDTO, Map<String, String> idMap) {
        ID id;
        try {
            id = this.getIdMapper().map(idMap);
        } catch (Exception e) {
            throw new RuntimeException(ERROR_ID);
        }
        return this.getViewDtoMapper()
                .map(this.getService().update(id, this.getUpdateDtoMapper()
                        .map(updateDTO))
                );

    }

    @Override
    public void delete(Map<String, String> idMap) {
        ID id;
        try {
            id = this.getIdMapper().map(idMap);
        } catch (Exception e) {
            throw new RuntimeException(ERROR_ID);
        }
        this.getService().delete(id);
    }
}
