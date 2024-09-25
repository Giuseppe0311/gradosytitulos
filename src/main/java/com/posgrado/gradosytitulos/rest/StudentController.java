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
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController extends AbstractCrudController<StudentsCreate, StudentsUpdate, StudentsViewDTO, Students, Long> {

    private final StudentsService service;
    private final StudentCreateMapper studentCreateMapper;
    private final StudentsUpdateMapper studentsUpdateMapper;
    private final StudentsViewMapper studentsViewMapper;
    private static final String STUDENT_ID = "studentId";


    @GetMapping("/{" + STUDENT_ID + "}")
    @Override
    public StudentsViewDTO getById(Map<String, String> idMap) {
        return super.getById(idMap);
    }

    @PutMapping("/{" + STUDENT_ID + "}")
    @Override
    public StudentsViewDTO update(StudentsUpdate updateDTO, Map<String, String> idMap) {
        return super.update(updateDTO, idMap);
    }

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
