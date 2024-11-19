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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Tag(name = "Grados", description = "API de grados")
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
    @Operation(
            summary = "Obtener todos los grados",
            description = "Obtener todos los grados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Grados encontrados"),
            @ApiResponse(responseCode = "404", description = "Grados no encontrados"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public List<DegreesViewDTO> getAll() {
        return super.getAll();
    }

    @Override
    @Operation(
            summary = "Obtener grado por id",
            description = "Obtener grado por id",
            parameters = {
                   @Parameter(
                            in = ParameterIn.PATH,
                            name = IDGRADO,
                            description = "Id del grado",
                            required = true,
                            example = "1",
                            schema = @Schema(type = "integer")
                   )
            }

    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Grado encontrado"),
            @ApiResponse(responseCode = "404", description = "Grado no encontrado"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @GetMapping("/{" + IDGRADO + "}")
    public DegreesViewDTO getById(Map<String, String> idMap) {
        return super.getById(idMap);
    }


    @Override
    @Operation(
            summary = "Crear grado",
            description = "Crear grado"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Grado creado"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public DegreesViewDTO create(DegreesCreate createDTO) {
        return super.create(createDTO);
    }

    @Override
    @Operation(
            summary = "Actualizar grado",
            description = "Actualizar grado",
            parameters = {
            @Parameter(
                    in = ParameterIn.PATH,
                    name = IDGRADO,
                    description = "Id del grado",
                    required = true,
                    example = "1",
                    schema = @Schema(type = "integer")
            )
    }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Grado actualizado"),
            @ApiResponse(responseCode = "404", description = "Grado no encontrado"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping("/{" + IDGRADO + "}")
    public DegreesViewDTO update(DegreesUpdate updateDTO, Map<String, String> idMap) {
        return super.update(updateDTO, idMap);
    }

    @Override
    @Operation(
            summary = "Eliminar grado",
            description = "Eliminar grado",
            parameters = {
                    @Parameter(
                            in = ParameterIn.PATH,
                            name = IDGRADO,
                            description = "Id del grado",
                            required = true,
                            example = "1",
                            schema = @Schema(type = "integer")
                    )
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Grado eliminado"),
            @ApiResponse(responseCode = "404", description = "Grado no encontrado"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @DeleteMapping("/delete/{" + IDGRADO + "}")
    public void delete(Map<String, String> idMap) {
        super.delete(idMap);
    }


    @Override
    protected DTOMapper<Map<String, String>, Long> getIdMapper() {
        return id->Long.parseLong(id.get(IDGRADO));
    }
}
