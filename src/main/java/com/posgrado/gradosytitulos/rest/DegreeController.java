package com.posgrado.gradosytitulos.rest;

import com.posgrado.gradosytitulos.domain.Degrees;
import com.posgrado.gradosytitulos.dto.dto.degrees.DegreesCreate;
import com.posgrado.gradosytitulos.dto.dto.degrees.DegreesUpdate;
import com.posgrado.gradosytitulos.dto.dto.degrees.DegreesViewDTO;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import com.posgrado.gradosytitulos.dto.mappers.degrees.DegreeCreateMapper;
import com.posgrado.gradosytitulos.dto.mappers.degrees.DegreeUpdateMapper;
import com.posgrado.gradosytitulos.dto.mappers.degrees.DegreeViewMapper;
import com.posgrado.gradosytitulos.services.CrudService;
import com.posgrado.gradosytitulos.services.DegreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/degrees")
@RequiredArgsConstructor
public class DegreeController extends AbstractCrudController<DegreesCreate, DegreesUpdate, DegreesViewDTO, Degrees,Long>{
    private final DegreeService service;
    private final DegreeCreateMapper createMapper;
    private final DegreeUpdateMapper updateMapper;
    private final DegreeViewMapper viewMapper;
    private static final String IDGRADO = "id";
    @Override
    protected CrudService<Degrees, Long> getService() {
        return service;
    }

    @Override
    protected DTOMapper<DegreesCreate, Degrees> getCreateDtoMapper() {
        return createMapper;
    }

    @Override
    protected DTOMapper<DegreesUpdate, Degrees> getUpdateDtoMapper() {
        return updateMapper;
    }

    @Override
    protected DTOMapper<Degrees, DegreesViewDTO> getViewDtoMapper() {
        return viewMapper;
    }

    @Override
    @GetMapping("/{" + IDGRADO + "}")
    public DegreesViewDTO getById(Map<String, String> idMap) {
        return super.getById(idMap);
    }

    @Override
    @PutMapping("/{" + IDGRADO + "}")
    public DegreesViewDTO update(DegreesUpdate updateDTO, Map<String, String> idMap) {
        return super.update(updateDTO, idMap);
    }

    @Override
    @DeleteMapping("/delete/{" + IDGRADO + "}")
    public void delete(Map<String, String> idMap) {
        super.delete(idMap);
    }

    @Override
    protected DTOMapper<Map<String, String>, Long> getIdMapper() {
        return id->Long.parseLong(id.get(IDGRADO));
    }
}
