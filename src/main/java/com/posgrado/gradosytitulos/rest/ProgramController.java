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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Tag(name = "Programs", description = "API para programas de estudio")
@RestController
@RequestMapping("/api/v1/programs")
@RequiredArgsConstructor
public class ProgramController extends AbstractCrudController<ProgramCreate, ProgramUpdate, ProgramView, Programs, Long> {


    private final ProgramService service;

    private final ProgramCreateMapper createMapper;

    private final ProgramUpdateMapper updateMapper;

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


    @Override
    @Operation(
            summary = "Obtener todos los programas",
            description = "Obtiene todos los programas de estudio"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Programa encontrado"),
            @ApiResponse(responseCode = "404", description = "Programa no encontrado"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public List<ProgramView> getAll() {
        return super.getAll();
    }

    @GetMapping("/{" + IDPROGRAM + "}")
    @Override
    @Operation(
            summary = "Obtener un programa por id",
            description = "Obtiene un programa de estudio por id",
            parameters = {
                    @Parameter(
                            in = ParameterIn.PATH,
                            name = IDPROGRAM,
                            description = "Id del programa",
                            required = true,
                            example = "1",
                            schema = @Schema(type = "integer")
                    )
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Programa encontrado"),
            @ApiResponse(responseCode = "404", description = "Programa no encontrado"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ProgramView getById(Map<String, String> idMap) {
        return super.getById(idMap);
    }


    @Override
    @Operation(
            summary = "Crear un programa",
            description = "Crea un programa de estudio"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Programa creado"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ProgramView create(ProgramCreate createDTO) {
        return super.create(createDTO);
    }

    @Override
    @PutMapping("/{" + IDPROGRAM + "}")
    @Operation(
            summary = "Actualizar un programa",
            description = "Actualiza un programa de estudio",
            parameters = {
                    @Parameter(
                            in = ParameterIn.PATH,
                            name = IDPROGRAM,
                            description = "Id del programa",
                            required = true,
                            example = "1",
                            schema = @Schema(type = "integer")
                    )
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Programa actualizado"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ProgramView update(ProgramUpdate updateDTO, Map<String, String> idMap) {
        return super.update(updateDTO, idMap);
    }

    @Override
    @DeleteMapping("/{" + IDPROGRAM + "}")
    @Operation(
            summary = "Eliminar un programa",
            description = "Elimina un programa de estudio",
            parameters = {
                    @Parameter(
                            in = ParameterIn.PATH,
                            name = IDPROGRAM,
                            description = "Id del programa",
                            required = true,
                            example = "1",
                            schema = @Schema(type = "integer")
                    )
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Programa eliminado"),
            @ApiResponse(responseCode = "404", description = "Programa no encontrado"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
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
