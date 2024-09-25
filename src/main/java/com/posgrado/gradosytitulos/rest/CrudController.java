package com.posgrado.gradosytitulos.rest;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @param <C> Represent CreateDTO
 * @param <U> Represent UpdateDTO
 * @param <V> Represent SearchDTO
 */

public interface CrudController<C, U, V> {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<V> getAll();

    @ResponseStatus(HttpStatus.OK)
    V getById(@PathVariable(required = false) Map<String, String> idMap);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    V create(@Valid @RequestBody C createDTO);

    @ResponseStatus(HttpStatus.OK)
    V update(@Valid @RequestBody U updateDTO, @PathVariable(required = false) Map<String, String> idMap);

    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable(required = false) Map<String, String> idMap);
}
