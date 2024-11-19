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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Tag(name = "Inscripciones", description = "API de inscripciones")
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
    @Operation(
            summary = "Obtener todas las inscripciones",
            description = "Obtener todas las inscripciones"
    )
    @ApiResponses(value = {

            @ApiResponse(responseCode = "200", description = "Incripciones encontrados"),
            @ApiResponse(responseCode = "404", description = "Incripciones no encontrados"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")

    })
    public List<InscriptionView> getAll() {
        return super.getAll();
    }


    @Override
    @Operation(
            summary = "Obtener inscripcion por id",
            description = "Obtener inscripcion por id",
            parameters = {
                    @Parameter(
                            in = ParameterIn.PATH,
                            name = IDINSCRIPTION,
                            description = "Id de la inscripcion",
                            required = true,
                            example = "1",
                            schema = @Schema(type = "integer")
                    )
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inscripcion encontrada"),
            @ApiResponse(responseCode = "404", description = "Inscripcion no encontrada"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{" + IDINSCRIPTION + "}")
    public InscriptionView getById(Map<String, String> idMap) {
        return super.getById(idMap);
    }


    @Override
    @Operation(
            summary = "Crear inscripcion",
            description = "Crear inscripcion"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inscripcion creada"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public InscriptionView create(InscriptionCreate createDTO) {
        return super.create(createDTO);
    }

    @Override
    @Operation(
            summary = "Actualizar inscripcion",
            description = "Actualizar inscripcion",
            parameters = {
                    @Parameter(
                            in = ParameterIn.PATH,
                            name = IDINSCRIPTION,
                            description = "Id de la inscripcion",
                            required = true,
                            example = "1",
                            schema = @Schema(type = "integer")
                    )
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Inscripcion actualizada"),
            @ApiResponse(responseCode = "404", description = "Inscripcion no encontrada"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping("/{" + IDINSCRIPTION + "}")
    public InscriptionView update(InscriptionUpdate updateDTO, Map<String, String> idMap) {
        return super.update(updateDTO, idMap);
    }

    @Override
    @Operation(
            summary = "Eliminar inscripcion",
            description = "Eliminar inscripcion",
            parameters = {
                    @Parameter(
                            in = ParameterIn.PATH,
                            name = IDINSCRIPTION,
                            description = "Id de la inscripcion",
                            required = true,
                            example = "1",
                            schema = @Schema(type = "integer")
                    )
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Inscripcion eliminada"),
            @ApiResponse(responseCode = "400", description = "Id de inscripcion no válido"),
            @ApiResponse(responseCode = "404", description = "Inscripcion no encontrada")
    })
    @DeleteMapping("/delete/{" + IDINSCRIPTION + "}")
    public void delete(Map<String, String> idMap) {
        super.delete(idMap);
    }

    @Override
    protected DTOMapper<Map<String, String>, Long> getIdMapper() {
        return id -> Long.parseLong(id.get(IDINSCRIPTION));
    }
}
