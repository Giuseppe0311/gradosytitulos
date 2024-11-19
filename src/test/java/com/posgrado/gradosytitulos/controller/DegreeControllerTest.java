package com.posgrado.gradosytitulos.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.posgrado.gradosytitulos.domain.Degrees;
import com.posgrado.gradosytitulos.dto.dto.degrees.DegreesCreate;
import com.posgrado.gradosytitulos.dto.dto.degrees.DegreesUpdate;
import com.posgrado.gradosytitulos.dto.dto.degrees.DegreesViewDTO;
import com.posgrado.gradosytitulos.dto.mappers.degrees.DegreeCreateMapper;
import com.posgrado.gradosytitulos.dto.mappers.degrees.DegreeUpdateMapper;
import com.posgrado.gradosytitulos.dto.mappers.degrees.DegreeViewMapper;
import com.posgrado.gradosytitulos.services.DegreeService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
public class DegreeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DegreeService degreeService;

    @MockBean
    private DegreeViewMapper degreeViewMapper;

    @MockBean
    private DegreeCreateMapper degreeCreateMapper;

    @MockBean

    private DegreeUpdateMapper degreeUpdateMapper;


    @Test
    @WithMockUser(roles = "admin_client")
    void testGetAllDegrees() throws Exception {

        DegreesViewDTO degreesViewDTO = new DegreesViewDTO(1L, "name");
        Degrees degrees = new Degrees();
        when(degreeService.findAll()).thenReturn(List.of(degrees));
        when(degreeViewMapper.map(degrees)).thenReturn(degreesViewDTO);

        mockMvc.perform(get("/api/v1/degrees").content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        verify(degreeService).findAll();
        verify(degreeViewMapper).map(degrees);

    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testGetDegreeById() throws Exception {
        DegreesViewDTO degreesViewDTO = new DegreesViewDTO(1L, "name");
        Degrees degrees = new Degrees();
        when(degreeService.getById(1L)).thenReturn(Optional.of(degrees));
        when(degreeViewMapper.map(degrees)).thenReturn(degreesViewDTO);

        mockMvc.perform(get("/api/v1/degrees/1").content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());

        verify(degreeService).getById(1L);
        verify(degreeViewMapper).map(degrees);
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testSaveDegreesById() throws Exception {
        DegreesViewDTO degreesViewDTO = new DegreesViewDTO(1L, "name");
        DegreesCreate degreesCreate = new DegreesCreate("name");
        Degrees degrees = new Degrees();
        when(degreeCreateMapper.map(degreesCreate)).thenReturn(degrees);
        when(degreeService.create(degrees)).thenReturn(degrees);
        when(degreeViewMapper.map(degrees)).thenReturn(degreesViewDTO);

        // Convertir el objeto a JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = objectMapper.writeValueAsString(degreesCreate);

        mockMvc.perform(
                        post("/api/v1/degrees")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonContent)
                )
                .andExpect(status().isCreated());
        verify(degreeCreateMapper).map(degreesCreate);
        verify(degreeService).create(degrees);
        verify(degreeViewMapper).map(degrees);
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testUpdateDegreesById() throws Exception {
        DegreesViewDTO degreesViewDTO = new DegreesViewDTO(1L, "name");
        Degrees degrees = new Degrees();
        Long id = 1L;
        DegreesUpdate degreesUpdate = new DegreesUpdate("name");
        when(degreeUpdateMapper.map(degreesUpdate)).thenReturn(degrees);
        when(degreeService.update(id, degrees)).thenReturn(degrees);
        when(degreeViewMapper.map(degrees)).thenReturn(degreesViewDTO);

        // Convertir el objeto a JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = objectMapper.writeValueAsString(degreesUpdate);

        mockMvc.perform(
                        put("/api/v1/degrees/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(jsonContent)
                )
                .andExpect(status().isOk());
        verify(degreeUpdateMapper).map(degreesUpdate);
        verify(degreeService).update(id, degrees);
        verify(degreeViewMapper).map(degrees);
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testDeleteDegreesById() throws Exception {
        Long id = 1L;
        doNothing().when(degreeService).delete(id);
        mockMvc.perform(
                        delete("/api/v1/degrees/delete/{id}", id)
                )
                .andExpect(status().isNoContent());
        verify(degreeService).delete(id);
    }

}
