package com.posgrado.gradosytitulos.controller;

import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.posgrado.gradosytitulos.domain.Students;
import com.posgrado.gradosytitulos.dto.dto.students.StudentsCreate;
import com.posgrado.gradosytitulos.dto.dto.students.StudentsUpdate;
import com.posgrado.gradosytitulos.dto.dto.students.StudentsViewDTO;
import com.posgrado.gradosytitulos.dto.mappers.students.StudentCreateMapper;
import com.posgrado.gradosytitulos.dto.mappers.students.StudentsUpdateMapper;
import com.posgrado.gradosytitulos.dto.mappers.students.StudentsViewMapper;
import com.posgrado.gradosytitulos.services.StudentsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentsService studentsService;

    @MockBean
    private StudentsViewMapper studentViewMapper;

    @MockBean
    private StudentsUpdateMapper studentsUpdateMapper;

    @MockBean
    private StudentCreateMapper studentCreateMapper;

    private StudentsViewDTO studentsViewDTO;

    @BeforeEach
    void setUp() {
        studentsViewDTO = new StudentsViewDTO(
                1L,
                null,
                null,
                null,
                null,
                null, null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testGetAllStudents() throws Exception {
        Students students = new Students();
        when(studentsService.findAll()).thenReturn(List.of(students));
        when(studentViewMapper.map(students)).thenReturn(studentsViewDTO);
        mockMvc.perform(get("/api/v1/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

        verify(studentsService).findAll();
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testGetSudentsById() throws Exception {
        Students students = new Students();
        Long id = 1L;
        when(studentsService.getById(id)).thenReturn(Optional.of(students));
        when(studentViewMapper.map(students)).thenReturn(studentsViewDTO);
        mockMvc.perform(get("/api/v1/students/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
        verify(studentsService).getById(id);
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testSaveStudent() throws Exception {
        StudentsCreate studentsCreate = new StudentsCreate(
                "12345678",
                "Juan",
                "Pérez",
                "Gómez",
                "juan.perez@email.com",
                "123456789",
                2L,
                "photo.jpg"
        );

        Students students = new Students();
        when(studentCreateMapper.map(studentsCreate)).thenReturn(students);
        when(studentsService.create(students)).thenReturn(students);
        when(studentViewMapper.map(students)).thenReturn(studentsViewDTO);
        ObjectMapper objectMapper = new ObjectMapper();
        String studentJson = objectMapper.writeValueAsString(studentsCreate);
        mockMvc.perform(post("/api/v1/students")
                        .content(studentJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());
        verify(studentsService).create(students);
        verify(studentCreateMapper).map(studentsCreate);
        verify(studentViewMapper).map(students);
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testUpdateStudent() throws Exception {
        Long id = 1L;
        Students students = new Students();
        StudentsUpdate studentsUpdate = new StudentsUpdate(
                "12345678",
                "Juan",
                "Pérez",
                "Gómez",
                "juan.perez@email.com",
                "123456789",
                "photo.jpg",
                2L
        );
        when(studentsUpdateMapper.map(studentsUpdate)).thenReturn(students);
        when(studentsService.update(id, students)).thenReturn(students);
        when(studentViewMapper.map(students)).thenReturn(studentsViewDTO);
        ObjectMapper objectMapper = new ObjectMapper();
        String studentJson = objectMapper.writeValueAsString(studentsUpdate);
        mockMvc.perform(put("/api/v1/students/{id}", id)
                        .content(studentJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
        verify(studentsService).update(id, students);
        verify(studentsUpdateMapper).map(studentsUpdate);
        verify(studentViewMapper).map(students);
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testDeleteStudent() throws Exception {
        Long id = 1L;
        doNothing().when(studentsService).delete(id);
        mockMvc.perform(delete("/api/v1/students/delete/{id}", id))
                .andExpect(status().isNoContent());
        verify(studentsService).delete(id);
    }
}
