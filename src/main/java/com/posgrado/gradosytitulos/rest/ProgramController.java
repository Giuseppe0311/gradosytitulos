package com.posgrado.gradosytitulos.rest;

import com.posgrado.gradosytitulos.domain.Programs;
import com.posgrado.gradosytitulos.dto.dto.progam.ProgramCreate;
import com.posgrado.gradosytitulos.dto.dto.progam.ProgramUpdate;
import com.posgrado.gradosytitulos.dto.dto.progam.ProgramView;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import com.posgrado.gradosytitulos.dto.mappers.program.ProgramCreateMapper;
import com.posgrado.gradosytitulos.dto.mappers.program.ProgramUpdateMapper;
import com.posgrado.gradosytitulos.dto.mappers.program.ProgramVieweMapper;
import com.posgrado.gradosytitulos.services.CrudService;
import com.posgrado.gradosytitulos.services.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/programs")
@RequiredArgsConstructor
public class ProgramController extends AbstractCrudController<ProgramCreate, ProgramUpdate, ProgramView, Programs,Long>{


    private final ProgramService service;

    private final ProgramCreateMapper createMapper;

    private  final ProgramUpdateMapper updateMapper;

    private final ProgramVieweMapper viewMapper;

    private static final String IDPROGRAM = "id";

    @Override
    protected CrudService<Programs, Long> getService() {
        return service;
    }

    @Override
    protected DTOMapper<ProgramCreate, Programs> getCreateDtoMapper() {
        return createMapper;
    }

    @GetMapping("/{" + IDPROGRAM + "}")
    @Override
    public ProgramView getById(Map<String, String> idMap) {
        return super.getById(idMap);
    }

    @Override
    @PutMapping ("/{" + IDPROGRAM + "}")
    public ProgramView update(ProgramUpdate updateDTO, Map<String, String> idMap) {
        return super.update(updateDTO, idMap);
    }

    @Override
    @DeleteMapping("/{" + IDPROGRAM + "}")
    public void delete(Map<String, String> idMap) {
        super.delete(idMap);
    }

    @Override
    protected DTOMapper<ProgramUpdate, Programs> getUpdateDtoMapper() {
        return updateMapper;
    }

    @Override
    protected DTOMapper<Programs, ProgramView> getViewDtoMapper() {
        return viewMapper;
    }

    @Override
    protected DTOMapper<Map<String, String>, Long> getIdMapper() {
        return id -> Long.parseLong(id.get(IDPROGRAM));
    }
}
