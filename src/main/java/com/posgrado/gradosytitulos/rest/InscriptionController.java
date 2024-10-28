package com.posgrado.gradosytitulos.rest;


import com.posgrado.gradosytitulos.domain.Inscriptions;
import com.posgrado.gradosytitulos.dto.dto.Inscription.InscriptionCreate;
import com.posgrado.gradosytitulos.dto.dto.Inscription.InscriptionUpdate;
import com.posgrado.gradosytitulos.dto.dto.Inscription.InscriptionView;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import com.posgrado.gradosytitulos.dto.mappers.inscription.InscriptionCreateMapper;
import com.posgrado.gradosytitulos.dto.mappers.inscription.InscriptionUpdateMapper;
import com.posgrado.gradosytitulos.dto.mappers.inscription.InscriptionViewMapper;
import com.posgrado.gradosytitulos.services.CrudService;
import com.posgrado.gradosytitulos.services.InscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/inscription")
@RequiredArgsConstructor
public class InscriptionController  extends AbstractCrudController<InscriptionCreate, InscriptionUpdate, InscriptionView, Inscriptions,Long> {

    private final InscriptionService service;

    private final InscriptionCreateMapper createMapper;

    private final InscriptionUpdateMapper updateMapper;

    private final InscriptionViewMapper viewMapper;

    private static final String IDINSCRIPTION = "id";

    @Override
    public List<InscriptionView> getAll() {
        return super.getAll();
    }

    @Override
    protected CrudService<Inscriptions, Long> getService() {
        return service;
    }

    @Override
    protected DTOMapper<InscriptionCreate, Inscriptions> getCreateDtoMapper() {
        return createMapper;
    }

    @Override
    protected DTOMapper<InscriptionUpdate, Inscriptions> getUpdateDtoMapper() {
        return updateMapper;
    }

    @Override
    protected DTOMapper<Inscriptions, InscriptionView> getViewDtoMapper() {
        return viewMapper;
    }

    @Override
    @GetMapping("/{" + IDINSCRIPTION + "}")
    public InscriptionView getById(Map<String, String> idMap) {
        return super.getById(idMap);
    }

    @Override
    @PutMapping("/{" + IDINSCRIPTION + "}")
    public InscriptionView update(InscriptionUpdate updateDTO, Map<String, String> idMap) {
        return super.update(updateDTO, idMap);
    }

    @Override
    @DeleteMapping("/delete/{" + IDINSCRIPTION + "}")
    public void delete(Map<String, String> idMap) {
        super.delete(idMap);
    }

    @Override
    protected DTOMapper<Map<String, String>, Long> getIdMapper() {
        return id -> Long.parseLong(id.get(IDINSCRIPTION));
    }
}
