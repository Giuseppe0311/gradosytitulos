package com.posgrado.gradosytitulos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.posgrado.gradosytitulos.domain.Programs;
import com.posgrado.gradosytitulos.dto.dto.progam.ProgramCreate;
import com.posgrado.gradosytitulos.dto.dto.progam.ProgramUpdate;
import com.posgrado.gradosytitulos.dto.dto.progam.ProgramView;
import com.posgrado.gradosytitulos.dto.mappers.program.ProgramCreateMapper;
import com.posgrado.gradosytitulos.dto.mappers.program.ProgramUpdateMapper;
import com.posgrado.gradosytitulos.dto.mappers.program.ProgramVieweMapper;
import com.posgrado.gradosytitulos.services.ProgramService;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ProgramControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProgramService programService;

    @MockBean
    private ProgramVieweMapper programVieweMapper;

    @MockBean
    private ProgramUpdateMapper programUpdateMapper;

    @MockBean
    private ProgramCreateMapper programCreateMapper;


    @Test
    @WithMockUser(roles = "admin_client")
    void testGetAllPrograms() throws Exception {

        ProgramView programView = new ProgramView(
                1L,
                null,
                null,
                null,
                null
        );
        Programs program = new Programs();

        when(programService.findAll()).thenReturn(List.of(program));
        when(programVieweMapper.map(program)).thenReturn(programView);

        mockMvc.perform(get("/api/v1/programs").content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        verify(programService).findAll();
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testGetProgramById() throws Exception {
        ProgramView programView = new ProgramView(
                1L,
                null,
                null,
                null,
                null
        );
        Programs program = new Programs();
        Long id = 1L;
        when(programService.getById(id)).thenReturn(Optional.of(program));
        when(programVieweMapper.map(program)).thenReturn(programView);

        mockMvc.perform(get("/api/v1/programs/1").content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
        verify(programService).getById(id);
        verify(programVieweMapper).map(program);
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testSaveProgram() throws Exception {
        ProgramView programView = new ProgramView(
                1L,
                null,
                null,
                null,
                null
        );
        Programs program = new Programs();
        ProgramCreate programCreate = new ProgramCreate(
                null,
                null,
                null,
                null,
                null
        );
        when(programCreateMapper.map(programCreate)).thenReturn(program);
        when(programService.create(program)).thenReturn(program);
        when(programVieweMapper.map(program)).thenReturn(programView);
        ObjectMapper objectMapper = new ObjectMapper();
        String programJson = objectMapper.writeValueAsString(programCreate);
        mockMvc.perform(post("/api/v1/programs")
                        .content(programJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());
        verify(programCreateMapper).map(programCreate);
        verify(programService).create(program);
        verify(programVieweMapper).map(program);
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testUpdateProgram() throws Exception {
        ProgramView programView = new ProgramView(
                1L,
                null,
                null,
                null,
                null
        );
        ProgramUpdate programUpdate = new ProgramUpdate(
                null,
                null,
                null,
                null
        );
        Programs program = new Programs();
        Long id = 1L;
        when(programUpdateMapper.map(programUpdate)).thenReturn(program);
        when(programService.update(id, program)).thenReturn(program);
        when(programVieweMapper.map(program)).thenReturn(programView);
        ObjectMapper objectMapper = new ObjectMapper();
        String programJson = objectMapper.writeValueAsString(programUpdate);
        mockMvc.perform(put("/api/v1/programs/{id}", id)
                        .content(programJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
        verify(programService).update(id, program);
        verify(programVieweMapper).map(program);
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testDeleteProgram() throws Exception {
        Long id = 1L;
        doNothing().when(programService).delete(id);
        mockMvc.perform(delete("/api/v1/programs/{id}", id))
                .andExpect(status().isNoContent());
        verify(programService).delete(id);
    }
}
