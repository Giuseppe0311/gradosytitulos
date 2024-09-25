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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/inscription")
@RequiredArgsConstructor
public class InscriptionController  extends AbstractCrudController<InscriptionCreate, InscriptionUpdate, InscriptionView, Inscriptions,Long> {

    private final InscriptionService service;

    private final InscriptionCreateMapper createMapper;

    private final InscriptionUpdateMapper updateMapper;

    private final InscriptionViewMapper viewMapper;

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
    protected DTOMapper<Map<String, String>, Long> getIdMapper() {
        return id -> Long.parseLong(id.get("id"));
    }
}
