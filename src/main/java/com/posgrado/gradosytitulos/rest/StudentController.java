package com.posgrado.gradosytitulos.rest;

import com.posgrado.gradosytitulos.domain.Students;
import com.posgrado.gradosytitulos.dto.dto.students.StudentsCreate;
import com.posgrado.gradosytitulos.dto.dto.students.StudentsUpdate;
import com.posgrado.gradosytitulos.dto.dto.students.StudentsViewDTO;
import com.posgrado.gradosytitulos.dto.mappers.DTOMapper;
import com.posgrado.gradosytitulos.dto.mappers.students.StudentCreateMapper;
import com.posgrado.gradosytitulos.dto.mappers.students.StudentsUpdateMapper;
import com.posgrado.gradosytitulos.dto.mappers.students.StudentsViewMapper;
import com.posgrado.gradosytitulos.services.CrudService;
import com.posgrado.gradosytitulos.services.StudentsService;
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


@Tag(name = "Estudiantes", description = "API de estudiantes")
@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController extends AbstractCrudController<StudentsCreate, StudentsUpdate, StudentsViewDTO, Students, Long> {

    private final StudentsService service;
    private final StudentCreateMapper studentCreateMapper;
    private final StudentsUpdateMapper studentsUpdateMapper;
    private final StudentsViewMapper studentsViewMapper;
    private static final String STUDENT_ID = "studentId";


    @Operation(
            summary = "Obtener todos los estudiantes",
            description = "Obtiene una lista de todos los estudiantes"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiantes encontrados"),
            @ApiResponse(responseCode = "404", description = "Estudiantes no encontrados"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @Override
    public List<StudentsViewDTO> getAll() {
        return super.getAll();
    }


    @GetMapping("/{" + STUDENT_ID + "}")
    @Operation(
            summary = "Obtener un estudiante por ID",
            description = "Obtiene un estudiante por ID",
            parameters = {
                    @Parameter(
                            name = STUDENT_ID,
                            in = ParameterIn.PATH,
                            description = "ID del estudiante",
                            example = "1",
                            schema = @Schema(type = "integer"),
                            required = true
                    )
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiante encontrado"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @Override
    public StudentsViewDTO getById(Map<String, String> idMap) {
        return super.getById(idMap);
    }


    @Override
    @Operation(
            summary = "Crear un estudiante",
            description = "Crea un estudiante"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Estudiante creado"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public StudentsViewDTO create(StudentsCreate createDTO) {
        return super.create(createDTO);
    }

    @Operation(
            summary = "Actualizar un estudiante",
            description = "Actualiza un estudiante",
            parameters = {
                    @Parameter(
                            name = STUDENT_ID,
                            in = ParameterIn.PATH,
                            description = "ID del estudiante",
                            example = "1",
                            schema = @Schema(type = "integer"),
                            required = true
                    )
            }
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiante actualizado"),
            @ApiResponse(responseCode = "400", description = "Error en los datos de entrada"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PutMapping("/{" + STUDENT_ID + "}")
    @Override
    public StudentsViewDTO update(StudentsUpdate updateDTO, Map<String, String> idMap) {
        return super.update(updateDTO, idMap);
    }

    @Operation(
            summary = "Eliminar un estudiante",
            description = "Elimina un estudiante",
            parameters = {
                    @Parameter(
                            name = STUDENT_ID,
                            in = ParameterIn.PATH,
                            description = "ID del estudiante",
                            example = "1",
                            schema = @Schema(type = "integer"),
                            required = true
                    )
            }
    )
    @DeleteMapping("/delete/{" + STUDENT_ID + "}")
    @Override
    public void delete(Map<String, String> idMap) {
        super.delete(idMap);
    }

    @Override
    protected CrudService<Students, Long> getService() {
        return service;
    }

    @Override
    protected DTOMapper<StudentsCreate, Students> getCreateDtoMapper() {
        return studentCreateMapper;
    }

    @Override
    protected DTOMapper<StudentsUpdate, Students> getUpdateDtoMapper() {
        return studentsUpdateMapper;
    }

    @Override
    protected DTOMapper<Students, StudentsViewDTO> getViewDtoMapper() {
        return studentsViewMapper;
    }

    @Override
    protected DTOMapper<Map<String, String>, Long> getIdMapper() {
        return map -> Long.parseLong(map.get(STUDENT_ID));
    }
}
